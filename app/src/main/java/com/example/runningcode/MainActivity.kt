package com.example.runningcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.runningcode.data.PreferenceManager
import com.example.runningcode.navigation.Screen
import com.example.runningcode.ui.screens.LessonDetailScreen
import com.example.runningcode.ui.screens.LessonListScreen
import com.example.runningcode.ui.screens.OnboardingScreen
import com.example.runningcode.ui.screens.SplashScreen
import com.example.runningcode.ui.theme.RunningCodeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            RunningCodeTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                val prefs = remember { PreferenceManager(context) }
                val startDestination = if (prefs.isOnboardingCompleted()) {
                    Screen.LessonList.route
                } else {
                    Screen.Splash.route
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = startDestination,
                        modifier = Modifier.padding(innerPadding),
                        enterTransition = { slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(400)) },
                        exitTransition = { slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(400)) },
                        popEnterTransition = { slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(400)) },
                        popExitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(400)) }
                    ) {
                        composable(Screen.Splash.route) {
                            SplashScreen(
                                onNavigate = {
                                    val destination = if (prefs.isOnboardingCompleted()) {
                                        Screen.LessonList.route
                                    } else {
                                        Screen.Onboarding.route
                                    }
                                    navController.navigate(destination) {
                                        popUpTo(Screen.Splash.route) { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable(Screen.Onboarding.route) {
                            OnboardingScreen(
                                onFinish = {
                                    prefs.setOnboardingCompleted()
                                    navController.navigate(Screen.LessonList.route) {
                                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable(Screen.LessonList.route) {
                            LessonListScreen(onLessonSelected = { lessonId ->
                                navController.navigate(Screen.LessonDetail.createRoute(lessonId))
                            })
                        }

                        composable(
                            route = Screen.LessonDetail.route,
                            arguments = listOf(navArgument("lessonId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val lessonId = backStackEntry.arguments?.getInt("lessonId") ?: 0
                            LessonDetailScreen(lessonId = lessonId, onBack = { navController.popBackStack() })
                        }
                    }
                }
            }
        }
    }
}
