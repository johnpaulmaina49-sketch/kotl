package com.example.runningcode.data

import android.content.Context
import kotlinx.serialization.json.Json

class LessonRepository(private val context: Context) {
    fun getLessons(): List<Lesson> {
        return try {
            val json = context.assets.open("lessons.json")
                .bufferedReader()
                .use { it.readText() }
            Json.decodeFromString(json)
        } catch (e: Exception) {
            emptyList()
        }
    }
}

