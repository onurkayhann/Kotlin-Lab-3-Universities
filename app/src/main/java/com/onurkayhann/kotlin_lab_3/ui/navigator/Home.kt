package com.onurkayhann.kotlin_lab_3.ui.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.onurkayhann.kotlin_lab_3.ui.screens.AboutScreen
import com.onurkayhann.kotlin_lab_3.ui.screens.LoggedInScreen
import com.onurkayhann.kotlin_lab_3.ui.screens.LoginScreen
import com.onurkayhann.kotlin_lab_3.ui.screens.RegisterScreen
import com.onurkayhann.kotlin_lab_3.ui.screens.WelcomeScreen

@Composable
fun Home() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcomeScreen") {
        composable("welcomeScreen") { WelcomeScreen(onNavigateToAboutScreen = { navController.navigate("aboutScreen") }) }
        composable("aboutScreen") { AboutScreen(onNavigateToLoginScreen = { navController.navigate("loginScreen") }) }
        composable("registerScreen") { RegisterScreen(onNavigateToLoginScreen = { navController.navigate("loginScreen") }) }
        composable("loginScreen") {
            LoginScreen(
                onNavigateToRegisterScreen = { navController.navigate("registerScreen") },
                onNavigateToLoggedInScreen = { username -> navController.navigate("loggedInScreen/$username") }
            )
        }
        composable("loggedInScreen/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username")
            LoggedInScreen(username = username ?: "")
        }
    }
}