package com.farmtopalm.terminal.data.repo

import com.farmtopalm.terminal.data.db.dao.TerminalConfigDao
import com.farmtopalm.terminal.data.db.entities.TerminalConfigEntity

class TerminalRepo(private val dao: TerminalConfigDao) {

    suspend fun getConfig() = dao.get()
    suspend fun isActivated() = dao.get() != null

    suspend fun saveConfig(terminalId: String, schoolId: String, apiBaseUrl: String, tokenEnc: ByteArray) {
        val now = System.currentTimeMillis()
        dao.insert(TerminalConfigEntity(id = 1, terminalId = terminalId, schoolId = schoolId, apiBaseUrl = apiBaseUrl, apiBaseUrlFallback = null, tokenEnc = tokenEnc, activatedAt = now, lastHeartbeatAt = null))
    }

    suspend fun updateHeartbeat() = dao.updateHeartbeat(System.currentTimeMillis())

    /** Update primary API base URL (cloud/Supabase backend). */
    suspend fun updateApiBaseUrl(apiBaseUrl: String) {
        dao.get()?.let { dao.insert(it.copy(apiBaseUrl = apiBaseUrl.trim().trimEnd('/'))) }
    }

    /** Update fallback API URL (local backend; used only when primary is unreachable). */
    suspend fun updateApiBaseUrlFallback(fallback: String?) {
        dao.get()?.let { dao.insert(it.copy(apiBaseUrlFallback = fallback?.trim()?.trimEnd('/')?.takeIf { s -> s.isNotEmpty() })) }
    }
}
