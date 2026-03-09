package com.farmtopalm.terminal.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.farmtopalm.terminal.sync.SyncScheduler
import com.farmtopalm.terminal.sync.SyncWorker

@Composable
fun SyncStatusScreen(
    unsyncedAttendance: Int,
    unsyncedMeals: Int,
    lastSyncTime: Long?,
    onSyncNow: () -> Unit,
    onSyncStudentsFromSupaSchool: () -> Unit,
    syncStudentsMessage: String?,
    syncStudentsLoading: Boolean,
    onRefreshCounts: () -> Unit,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val workInfos by WorkManager.getInstance(context)
        .getWorkInfosForUniqueWorkLiveData(SyncScheduler.SYNC_NOW_WORK_NAME)
        .observeAsState(initial = emptyList())

    var showSyncStartedDialog by remember { mutableStateOf(false) }
    val currentWork = workInfos.firstOrNull()
    val isSyncing = currentWork?.state == WorkInfo.State.RUNNING
    val syncSucceeded = currentWork?.state == WorkInfo.State.SUCCEEDED
    val syncFailed = currentWork?.state == WorkInfo.State.FAILED

    val progress = currentWork?.progress?.getInt(SyncWorker.KEY_PROGRESS, 0) ?: 0
    val stage = currentWork?.progress?.getString(SyncWorker.KEY_STAGE) ?: ""

    // Refresh counts when sync completes; add delay to ensure DB writes are committed
    LaunchedEffect(syncSucceeded, syncFailed) {
        if (syncSucceeded || syncFailed) {
            onRefreshCounts()
            kotlinx.coroutines.delay(400)
            onRefreshCounts()
        }
    }
    // Periodic refresh while on sync screen so counts stay accurate
    LaunchedEffect(Unit) {
        while (true) {
            kotlinx.coroutines.delay(3000)
            onRefreshCounts()
        }
    }

    if (showSyncStartedDialog) {
        AlertDialog(
            onDismissRequest = { showSyncStartedDialog = false },
            title = { Text("Sync started") },
            text = { Text("Syncing attendance, meals, and palm data in the background. You can watch the progress below.") },
            confirmButton = {
                TextButton(onClick = { showSyncStartedDialog = false }) {
                    Text("OK")
                }
            }
        )
    }

    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("Sync Status", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text("Unsynced attendance: $unsyncedAttendance")
                Text("Unsynced meals: $unsyncedMeals")
                Text("Last sync: ${if (lastSyncTime != null) java.text.SimpleDateFormat.getDateTimeInstance().format(java.util.Date(lastSyncTime)) else "Never"}")
            }
            TextButton(onClick = onRefreshCounts) { Text("Refresh") }
        }
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                showSyncStartedDialog = true
                onSyncNow()
            },
            modifier = Modifier.heightIn(min = 48.dp),
            enabled = !isSyncing
        ) {
            Text(if (isSyncing) "Syncing…" else "Sync now")
        }

        if (isSyncing || syncSucceeded || syncFailed) {
            Spacer(Modifier.height(12.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = when {
                        isSyncing -> MaterialTheme.colorScheme.surfaceVariant
                        syncSucceeded -> MaterialTheme.colorScheme.primaryContainer
                        else -> MaterialTheme.colorScheme.errorContainer
                    }
                )
            ) {
                Column(Modifier.padding(16.dp)) {
                    if (isSyncing) {
                        Text(stage.ifBlank { "Syncing…" }, style = MaterialTheme.typography.bodyMedium)
                        Spacer(Modifier.height(8.dp))
                        LinearProgressIndicator(
                            progress = { progress.toFloat() / 100f },
                            modifier = Modifier.fillMaxWidth().height(8.dp)
                        )
                    } else if (syncSucceeded) {
                        Text("Sync complete", style = MaterialTheme.typography.bodyMedium)
                    } else if (syncFailed) {
                        Column {
                            Text("Sync failed. Will retry automatically.", style = MaterialTheme.typography.bodyMedium)
                            if (stage.isNotBlank() && stage != "Sync had errors") {
                                Spacer(Modifier.height(4.dp))
                                Text(stage, style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Text("Supa School", style = MaterialTheme.typography.titleMedium)
        Text("Sync student list from Supa School so attendance/meals show on the dashboard.", style = MaterialTheme.typography.bodySmall)
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = onSyncStudentsFromSupaSchool,
            modifier = Modifier.heightIn(min = 48.dp),
            enabled = !syncStudentsLoading
        ) { Text(if (syncStudentsLoading) "Syncing…" else "Sync students from Supa School") }
        if (syncStudentsMessage != null) {
            Spacer(Modifier.height(4.dp))
            Text(syncStudentsMessage, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
        }
        Spacer(Modifier.height(16.dp))
        TextButton(onClick = onBack, modifier = Modifier.heightIn(min = 48.dp)) { Text("Back") }
    }
}
