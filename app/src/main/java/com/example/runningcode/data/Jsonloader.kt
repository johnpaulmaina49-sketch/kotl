package com.example.runningcode.data

import android.content.Context
import kotlinx.serialization.json.Json

fun loadLessons(context: Context): List<Lesson> {
    val json = context.assets.open("lessons.json")
        .bufferedReader().use { it.readText() }

    return Json.decodeFromString(json)
}

