package com.example.runningcode.data

import android.content.Context
import com.example.runningcode.loadLessonsFromAssets

class LessonRepository(private val context: Context) {
    fun getLessons(): List<Lesson> = loadLessonsFromAssets(context)
}

