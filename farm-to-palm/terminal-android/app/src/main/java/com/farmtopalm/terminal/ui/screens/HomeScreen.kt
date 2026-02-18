package com.farmtopalm.terminal.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    todayAttendanceCount: Int,
    todayMealCount: Int,
    onAttendance: () -> Unit,
    onMeal: () -> Unit,
    onEnrollment: () -> Unit,
    onStudents: () -> Unit,
    onSyncStatus: () -> Unit,
    onDeviceStatus: () -> Unit,
    onSettings: () -> Unit,
    onAttendanceList: () -> Unit,
    onMealList: () -> Unit
) {
    val scroll = rememberScrollState()
    Column(Modifier.fillMaxSize().padding(16.dp).verticalScroll(scroll)) {
        Text("Today", style = MaterialTheme.typography.titleLarge)
        Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Card(Modifier.weight(1f).clickable { onAttendanceList() }) {
                Column(Modifier.padding(16.dp)) {
                    Text("Attendance")
                    Text("$todayAttendanceCount", style = MaterialTheme.typography.headlineMedium)
                }
            }
            Card(Modifier.weight(1f).clickable { onMealList() }) {
                Column(Modifier.padding(16.dp)) {
                    Text("Meals")
                    Text("$todayMealCount", style = MaterialTheme.typography.headlineMedium)
                }
            }
        }
        Spacer(Modifier.height(24.dp))
        Button(onClick = onAttendance, modifier = Modifier.fillMaxWidth().heightIn(min = 88.dp)) { Text("Attendance") }
        Spacer(Modifier.height(8.dp))
        Button(onClick = onMeal, modifier = Modifier.fillMaxWidth().heightIn(min = 88.dp)) { Text("Meal") }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onEnrollment, modifier = Modifier.fillMaxWidth().heightIn(min = 76.dp)) { Text("Enrollment") }
        OutlinedButton(onClick = onStudents, modifier = Modifier.fillMaxWidth().heightIn(min = 76.dp)) { Text("Students") }
        OutlinedButton(onClick = onSyncStatus, modifier = Modifier.fillMaxWidth().heightIn(min = 76.dp)) { Text("Sync Status") }
        OutlinedButton(onClick = onDeviceStatus, modifier = Modifier.fillMaxWidth().heightIn(min = 76.dp)) { Text("Device Status") }
        OutlinedButton(onClick = onSettings, modifier = Modifier.fillMaxWidth().heightIn(min = 76.dp)) { Text("Settings") }
    }
}
