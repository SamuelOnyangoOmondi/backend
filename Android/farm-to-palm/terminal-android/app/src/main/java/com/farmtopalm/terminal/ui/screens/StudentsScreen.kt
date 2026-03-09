package com.farmtopalm.terminal.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farmtopalm.terminal.data.db.entities.StudentEntity

private enum class FilterTab { All, NotRegistered, Registered }

private val AvatarColors = listOf(
    Color(0xFF6366F1),  // Indigo
    Color(0xFF14B8A6),  // Teal
    Color(0xFFEF4444),  // Red
    Color(0xFFF97316),  // Orange
    Color(0xFF8B5CF6),  // Purple
    Color(0xFF06B6D4),  // Cyan
)

@Composable
fun StudentsScreen(
    schoolId: String,
    students: List<StudentEntity>,
    enrolledStudentIds: Set<String>,
    totalStudentCount: Int,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    onBack: () -> Unit,
    onRegisterPalm: (StudentEntity) -> Unit = {},
    isLoading: Boolean = false
) {
    var filterTab by remember { mutableStateOf(FilterTab.NotRegistered) }
    val enrolledCount = enrolledStudentIds.size

    val filteredStudents = remember(students, enrolledStudentIds, filterTab) {
        when (filterTab) {
            FilterTab.All -> students
            FilterTab.NotRegistered -> students.filter { !enrolledStudentIds.contains(it.id) }
            FilterTab.Registered -> students.filter { enrolledStudentIds.contains(it.id) }
        }
    }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        // Header with back button
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            IconButton(
                onClick = onBack,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
            Column(Modifier.weight(1f)) {
                Text(
                    "Students",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    "Register palm for attendance",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                "$totalStudentCount",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(Modifier.height(16.dp))

        // Enrollment progress
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text(
                    "$enrolledCount / $totalStudentCount registered",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = { if (totalStudentCount > 0) enrolledCount.toFloat() / totalStudentCount else 0f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        // Search - full width, prominent
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchChange,
            placeholder = { Text("Search student name") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        Spacer(Modifier.height(12.dp))

        // Filter tabs
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterTab.entries.forEach { tab ->
                val isSelected = filterTab == tab
                val label = when (tab) {
                    FilterTab.All -> "All"
                    FilterTab.NotRegistered -> "Not Registered"
                    FilterTab.Registered -> "Registered"
                }
                FilterChip(
                    selected = isSelected,
                    onClick = { filterTab = tab },
                    label = { Text(label) },
                    modifier = Modifier.heightIn(min = 48.dp)
                )
            }
        }

        Spacer(Modifier.height(12.dp))

        // Student list
        if (isLoading) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                    Spacer(Modifier.height(8.dp))
                    Text("Loading students...", style = MaterialTheme.typography.bodyMedium)
                }
            }
        } else if (filteredStudents.isEmpty()) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No students found",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f, fill = true)
            ) {
                items(filteredStudents) { s ->
                    val hasPalm = enrolledStudentIds.contains(s.id)
                    StudentCard(
                        student = s,
                        hasPalm = hasPalm,
                        onRegisterPalm = { onRegisterPalm(s) }
                    )
                }
            }
        }
    }
}

@Composable
private fun StudentCard(
    student: StudentEntity,
    hasPalm: Boolean,
    onRegisterPalm: () -> Unit
) {
    val initial = student.name.firstOrNull()?.uppercaseChar()?.toString() ?: "?"
    val avatarColor = AvatarColors[initial.first().code % AvatarColors.size]

    Card(
        Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Avatar with initial
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(avatarColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    initial,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Name and status
            Column(Modifier.weight(1f)) {
                Text(
                    student.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    if (hasPalm) "✓ Palm registered" else "Palm not registered",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (hasPalm) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Action - Gray for Register, Green for Registered (per UX spec)
            if (hasPalm) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color(0xFFDCFCE7)  // Light green
                ) {
                    Row(
                        Modifier
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                            .heightIn(min = 48.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color(0xFF16A34A)  // Green
                        )
                        Text(
                            "Registered",
                            style = MaterialTheme.typography.labelLarge,
                            color = Color(0xFF16A34A)
                        )
                    }
                }
            } else {
                FilledTonalButton(
                    onClick = onRegisterPalm,
                    modifier = Modifier.heightIn(min = 48.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = Color(0xFFE9D5FF),  // Lavender
                        contentColor = Color(0xFF6B21A8)    // Purple
                    )
                ) {
                    Icon(Icons.Default.Fingerprint, contentDescription = null, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Register Palm")
                }
            }
        }
    }
}
