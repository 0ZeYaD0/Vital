package com.example.vital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import com.example.vital.ui.theme.AppTheme
import com.example.vital.ui.theme.screens.LoginScreen
import com.example.vital.ui.theme.screens.OnboardingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()  // ✅ Initialize NavController

            AppTheme {
                NavHost(navController = navController, startDestination = "onboarding") {
                    composable("onboarding") {
                        OnboardingScreen(
                            onLoginClick = { navController.navigate("login") },  // ✅ Works correctly
                            onSignUpClick = {}  // ✅ No action for Sign Up, prevents errors
                        )
                    }
                    composable("login") {
                        LoginScreen(navController)  // ✅ Pass navController correctly
                    }
                }
            }
        }
    }
}
