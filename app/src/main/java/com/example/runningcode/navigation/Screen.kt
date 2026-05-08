package com.example.runningcode.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object LessonList : Screen("lesson_list")
    object LessonDetail : Screen("lesson_detail/{lessonId}") {
        fun createRoute(lessonId: Int) = "lesson_detail/$lessonId"
    }
}

