package com.farmtopalm.terminal.sync

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.farmtopalm.terminal.data.crypto.Crypto
import com.farmtopalm.terminal.data.db.AppDatabase
import com.farmtopalm.terminal.data.repo.EventRepo
import com.farmtopalm.terminal.data.repo.TerminalRepo
import com.farmtopalm.terminal.util.Logger
import java.util.concurrent.TimeUnit

class SyncWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    private val db = AppDatabase.getInstance(context)
    private val terminalRepo = TerminalRepo(db.terminalConfigDao())
    private val eventRepo = EventRepo(db.attendanceEventDao(), db.mealEventDao())

    override suspend fun doWork(): Result {
        val config = terminalRepo.getConfig() ?: run {
            Logger.d("Sync skipped: not activated")
            return Result.success()
        }
        val tokenBytes = try {
            Crypto.decrypt(applicationContext, config.tokenEnc)
        } catch (e: Exception) {
            Logger.e("Sync: failed to decrypt token", e)
            return Result.retry()
        }
        val token = String(tokenBytes)
        val client = ApiClient(config.apiBaseUrl, config.apiBaseUrlFallback, token)

        val attendance = eventRepo.getUnsyncedAttendance()
        val meals = eventRepo.getUnsyncedMeals()
        val studentDao = db.studentDao()
        val studentIds = (attendance.map { it.studentId } + meals.map { it.studentId }).distinct()
        val idToExternal = mutableMapOf<String, String>()
        studentIds.forEach { id -> studentDao.getById(id)?.let { idToExternal[id] = it.externalId } }
        var ok = true
        if (attendance.isNotEmpty()) {
            when (client.postAttendanceBulk(attendance) { idToExternal[it] }) {
                is com.farmtopalm.terminal.util.Result.Success -> eventRepo.markAttendanceSynced(attendance.map { it.id })
                is com.farmtopalm.terminal.util.Result.Error -> ok = false
            }
        }
        if (meals.isNotEmpty()) {
            when (client.postMealsBulk(meals) { idToExternal[it] }) {
                is com.farmtopalm.terminal.util.Result.Success -> eventRepo.markMealsSynced(meals.map { it.id })
                is com.farmtopalm.terminal.util.Result.Error -> ok = false
            }
        }
        // Sync unsynced palm templates so SupaSchool profile shows "Palm registered"
        val unsyncedPalms = db.palmTemplateDao().getUnsynced()
        for (palm in unsyncedPalms) {
            val extId = studentDao.getById(palm.studentId)?.externalId ?: palm.studentId
            val rgb = try { com.farmtopalm.terminal.data.crypto.Crypto.decrypt(applicationContext, palm.rgbFeatureEnc) } catch (e: Exception) { null }
            val ir = try { com.farmtopalm.terminal.data.crypto.Crypto.decrypt(applicationContext, palm.irFeatureEnc) } catch (e: Exception) { null }
            if (rgb != null && ir != null) {
                when (client.postPalmSync(extId, palm.hand, rgb, ir, palm.quality)) {
                    is com.farmtopalm.terminal.util.Result.Success -> db.palmTemplateDao().markSynced(palm.id)
                    is com.farmtopalm.terminal.util.Result.Error -> ok = false
                }
            }
        }
        if (ok) terminalRepo.updateHeartbeat()
        return if (ok) Result.success() else Result.retry()
    }

    companion object {
        const val WORK_NAME = "FarmToPalmSync"
        val BACKOFF_DELAY = 5
        val BACKOFF_UNIT = TimeUnit.MINUTES
    }
}
