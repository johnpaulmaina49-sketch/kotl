package com.example.runningcode

import android.content.Context
import com.example.runningcode.data.Lesson
import kotlinx.serialization.json.Json

fun loadLessonsFromAssets(context: Context): List<Lesson> {
    return try {
        val jsonString = context.assets.open("lessons.json")
            .bufferedReader()
            .use { it.readText() }
        Json.decodeFromString(jsonString)
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}
