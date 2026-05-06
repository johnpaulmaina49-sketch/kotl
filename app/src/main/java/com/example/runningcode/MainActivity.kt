package com.example.runningcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.runningcode.navigation.RunningCodeApp
import com.example.runningcode.ui.theme.RunningCodeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            RunningCodeTheme {
                RunningCodeApp()
            }
        }
    }
}
