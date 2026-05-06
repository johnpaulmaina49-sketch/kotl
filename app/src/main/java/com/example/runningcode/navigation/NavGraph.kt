package com.example.runningcode.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.runningcode.ui.screens.LessonDetailScreen
import com.example.runningcode.ui.screens.LessonListScreen
import com.example.runningcode.ui.screens.OnboardingScreen

@Composable
fun RunningCodeApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route,

        enterTransition = {
            slideInHorizontally { 1000 }
        },
        exitTransition = {
            slideOutHorizontally { -1000 }
        },
        popEnterTransition = {
            slideInHorizontally { -1000 }
        },
        popExitTransition = {
            slideOutHorizontally { 1000 }
        }
    ) {

        composable(Screen.Onboarding.route) {
            OnboardingScreen {
                navController.navigate(Screen.LessonList.route) {
                    popUpTo(Screen.Onboarding.route) { inclusive = true }
                }
            }
        }

        composable(Screen.LessonList.route) {
            LessonListScreen {
                navController.navigate(Screen.LessonDetail.createRoute(it))
            }
        }

        composable(
            Screen.LessonDetail.route,
            arguments = listOf(navArgument("lessonId") { type = NavType.IntType })
        ) {
            val id = it.arguments?.getInt("lessonId") ?: 0
            LessonDetailScreen(lessonId = id, onBack = {
                navController.popBackStack()
            })
        }
    }
}
