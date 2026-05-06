package com.example.runningcode.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.runningcode.data.Lesson
import com.example.runningcode.data.LessonRepository

class LessonViewModel(app: Application) : AndroidViewModel(app) {
    var lessons = mutableStateOf<List<Lesson>>(emptyList())
        private set
    init {
        val repo = LessonRepository(app)
        lessons.value = repo.getLessons()
    }
    fun getLessonById(id: Int): Lesson? {
        return lessons.value.find { it.id == id }
    }
}
