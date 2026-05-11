package com.example.runningcode.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runningcode.data.Lesson
import com.example.runningcode.loadLessonsFromAssets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonDetailScreen(
    lessonId: Int,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val lessons = remember { loadLessonsFromAssets(context) }
    val lesson = lessons.find { it.id == lessonId }
        ?: Lesson(0, "Error", "Lesson not found.")

    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { 
                    Text(
                        lesson.title,
                        fontWeight = FontWeight.Bold
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack, 
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                )
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = lesson.content,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            lineHeight = 28.sp,
                            letterSpacing = 0.5.sp
                        ),
                        fontFamily = FontFamily.Serif
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Complete Lesson")
            }
        }
    }
}
