package com.example.runningcode.data

import android.content.Context

class PreferenceManager(context: Context) {

    private val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun setOnboardingCompleted() {
        prefs.edit().putBoolean("onboarding_done", true).apply()
    }

    fun isOnboardingCompleted(): Boolean {
        return prefs.getBoolean("onboarding_done", false)
    }
}
