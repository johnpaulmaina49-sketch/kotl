package com.example.runningcode.navigation

//import androidx.compose.animation.EnterTransition
//import androidx.compose.animation.ExitTransition
//import androidx.compose.animation.core.tween
//import androidx.compose.animation.slideInHorizontally
//import androidx.compose.animation.slideOutHorizontally
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.platform.LocalContext
//import androidx.navigation.NavHostController
//import androidx.navigation.NavType
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//import com.example.runningcode.data.PreferenceManager
//import com.example.runningcode.ui.screens.LessonDetailScreen
//import com.example.runningcode.ui.screens.LessonListScreen
//import com.example.runningcode.ui.screens.OnboardingScreen
//import com.example.runningcode.ui.screens.SplashScreen
//import com.google.accompanist.navigation.animation.AnimatedNavHost
//
//
//object Splash : Screen("splash")
//object Onboarding : Screen("onboarding")
//
//
//
//@Composable
//fun RunningCodeApp(
//) {
//    val navController = rememberNavController()
//    val context = LocalContext.current
//    val prefs = remember { PreferenceManager(context) }
//    val startDestination = if (prefs.isOnboardingCompleted()) {
//        Screen.LessonList.route
//    } else {
//        Screen.Splash.route
//    }
//
//    AnimatedNavHost(
//        navController = navController,
//        startDestination = startDestination,
//        enterTransition = {
//            slideInHorizontally(
//                initialOffsetX = { 1000 },
//                animationSpec = tween(300)
//            )
//        },
//        exitTransition = {
//            slideOutHorizontally(
//                targetOffsetX = { -1000 },
//                animationSpec = tween(300)
//            )
//        },
//        popEnterTransition = {
//            slideInHorizontally(
//                initialOffsetX = { -1000 },
//                animationSpec = tween(300)
//            )
//        },
//        popExitTransition = {
//            slideOutHorizontally(
//                targetOffsetX = { 1000 },
//                animationSpec = tween(300)
//            )
//        },
//    )
//
//
//    {
//      c
//        composable(Screen.LessonList.route) {
//            LessonListScreen(onLessonSelected =  { lessonId ->
//                navController.navigate(Screen.LessonDetail.createRoute(lessonId))
//            })
//        }
//
//
//        composable(
//            route = Screen.LessonDetail.route,
//            arguments = listOf(navArgument("lessonId") { type = NavType.IntType })
//        )
//        {backstackent
//            val lessonId = backStackEntry.arguments?.getInt("lessonId") ?: 0
//            LessonDetailScreen(lessonid = lessonId, onBack = { navController.popBackStack() })
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
