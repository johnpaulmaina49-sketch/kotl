package com.example.runningcode.viewmodel

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.runningcode.data.Lesson
import com.example.runningcode.loadLessonsFromAssets

class LessonViewModel(app: Application) : AndroidViewModel(app) {
    private val _lessons = mutableStateOf<List<Lesson>>(emptyList())
    val lessons: State<List<Lesson>> = _lessons

    init {
        loadLessons()
    }

    fun loadLessons() {
        _lessons.value = loadLessonsFromAssets(getApplication())
    }

    fun getLessonById(id: Int): Lesson? {
        return _lessons.value.find { it.id == id }
    }
}
