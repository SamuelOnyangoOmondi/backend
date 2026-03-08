package com.farmtopalm.terminal.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SyncStatusScreen(
    unsyncedAttendance: Int,
    unsyncedMeals: Int,
    lastSyncTime: Long?,
    onSyncNow: () -> Unit,
    onSyncStudentsFromSupaSchool: () -> Unit,
    syncStudentsMessage: String?,
    syncStudentsLoading: Boolean,
    onBack: () -> Unit
) {
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("Sync Status", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Text("Unsynced attendance: $unsyncedAttendance")
        Text("Unsynced meals: $unsyncedMeals")
        Text("Last sync: ${if (lastSyncTime != null) java.text.SimpleDateFormat.getDateTimeInstance().format(java.util.Date(lastSyncTime)) else "Never"}")
        Spacer(Modifier.height(16.dp))
        Button(onClick = onSyncNow, modifier = Modifier.heightIn(min = 48.dp)) { Text("Sync now") }
        Spacer(Modifier.height(12.dp))
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
