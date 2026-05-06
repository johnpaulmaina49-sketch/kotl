package com.example.runningcode.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.runningcode.viewmodel.LessonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonListScreen(
    modifier: Modifier = Modifier,
    viewModel: LessonViewModel = viewModel(),
    onLessonSelected: (Int) -> Unit
) {
    val lessons = viewModel.lessons.value
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text("Lessons") }) }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(lessons) { lesson ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onLessonSelected(lesson.id) }
                        .padding(16.dp)
                ) {
                    Text(text = lesson.title, style = MaterialTheme.typography.titleLarge)
                    Text("Tap to read")
                }
                HorizontalDivider()
            }
        }
    }
}
