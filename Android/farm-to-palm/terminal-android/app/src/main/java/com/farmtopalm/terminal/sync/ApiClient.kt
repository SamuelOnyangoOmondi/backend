package com.farmtopalm.terminal.sync

import com.farmtopalm.terminal.data.db.entities.AttendanceEventEntity
import com.farmtopalm.terminal.data.db.entities.MealEventEntity
import com.farmtopalm.terminal.util.Logger
import com.farmtopalm.terminal.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

data class SupaschoolStudent(
    val id: String,
    val firstName: String,
    val lastName: String,
    val admissionNumber: String
)

/**
 * API client that uses primary URL (cloud/Supabase backend) and optionally
 * falls back to a local URL when the primary is unreachable (no internet).
 */
class ApiClient(
    private val primaryBaseUrl: String,
    private val fallbackBaseUrl: String?,
    private val token: String
) {
    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
    private val jsonType = "application/json; charset=utf-8".toMediaType()

    suspend fun postAttendanceBulk(events: List<AttendanceEventEntity>, externalIdByStudentId: (String) -> String?): Result<Unit> = withContext(Dispatchers.IO) {
        val arr = JSONArray()
        events.forEach { e ->
            arr.put(JSONObject().apply {
                put("eventId", e.id)
                put("externalId", externalIdByStudentId(e.studentId))
                put("terminalId", e.terminalId)
                put("schoolId", e.schoolId)
                put("ts", e.ts)
                put("confidence", e.confidence.toDouble())
            })
        }
        tryPrimaryThenFallback { postWithUrl(it, "/v1/events/attendance/bulk", JSONObject().put("events", arr).toString()) }
    }

    suspend fun postMealsBulk(events: List<MealEventEntity>, externalIdByStudentId: (String) -> String?): Result<Unit> = withContext(Dispatchers.IO) {
        val arr = JSONArray()
        events.forEach { e ->
            arr.put(JSONObject().apply {
                put("eventId", e.id)
                put("externalId", externalIdByStudentId(e.studentId))
                put("terminalId", e.terminalId)
                put("schoolId", e.schoolId)
                put("ts", e.ts)
                put("method", e.method)
            })
        }
        tryPrimaryThenFallback { postWithUrl(it, "/v1/events/meals/bulk", JSONObject().put("events", arr).toString()) }
    }

    /**
     * Fetch students from Supa School (Supabase) for the terminal's school.
     * Tries primary (cloud) first; if unreachable, uses fallback (local) when set.
     */
    suspend fun getSupaschoolStudents(): Result<List<SupaschoolStudent>> = withContext(Dispatchers.IO) {
        tryPrimaryThenFallback { getSupaschoolStudentsWithUrl(it) }
    }

    private fun isNetworkFailure(error: Result.Error): Boolean {
        val cause = error.cause
        if (cause is IOException || cause is UnknownHostException) return true
        val msg = error.message.lowercase()
        return "connection" in msg || "failed to connect" in msg || "unable to resolve" in msg ||
            "timeout" in msg || "network" in msg || "connection refused" in msg
    }

    private inline fun <T> tryPrimaryThenFallback(block: (String) -> Result<T>): Result<T> {
        val primary = primaryBaseUrl.trimEnd('/')
        val result = block(primary)
        if (result is Result.Error && isNetworkFailure(result) && !fallbackBaseUrl.isNullOrBlank()) {
            Logger.d("ApiClient: primary unreachable, trying fallback")
            return block(fallbackBaseUrl!!.trimEnd('/'))
        }
        return result
    }

    private fun postWithUrl(baseUrl: String, path: String, body: String): Result<Unit> {
        val url = baseUrl + path
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .addHeader("Content-Type", jsonType.toString())
            .post(body.toRequestBody(jsonType))
            .build()
        return try {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) Result.Success(Unit)
            else {
                Logger.e("API error: ${response.code} ${response.body?.string()}")
                Result.Error("HTTP ${response.code}")
            }
        } catch (e: Exception) {
            Logger.e("API request failed", e)
            Result.Error(e.message ?: "Network error", e as? Throwable)
        }
    }

    private fun getSupaschoolStudentsWithUrl(baseUrl: String): Result<List<SupaschoolStudent>> {
        val url = baseUrl + "/v1/supaschool/students"
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .get()
            .build()
        return try {
            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                val body = response.body?.string() ?: ""
                Logger.e("Supaschool students API error: ${response.code} $body")
                return Result.Error("HTTP ${response.code}")
            }
            val json = JSONObject(response.body?.string() ?: "{}")
            val arr = json.optJSONArray("students") ?: JSONArray()
            val list = mutableListOf<SupaschoolStudent>()
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                list.add(
                    SupaschoolStudent(
                        id = o.optString("id"),
                        firstName = o.optString("firstName", ""),
                        lastName = o.optString("lastName", ""),
                        admissionNumber = o.optString("admissionNumber", "")
                    )
                )
            }
            Result.Success(list)
        } catch (e: Exception) {
            Logger.e("Supaschool students request failed", e)
            Result.Error(e.message ?: "Network error", e as? Throwable)
        }
    }
}
