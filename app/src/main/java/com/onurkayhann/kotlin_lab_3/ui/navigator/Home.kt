package com.onurkayhann.kotlin_lab_3.ui.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.onurkayhann.kotlin_lab_3.ui.screens.AboutScreen
import com.onurkayhann.kotlin_lab_3.ui.screens.WelcomeScreen

@Composable
fun Home() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcomeScreen") {
        composable("welcomeScreen") { WelcomeScreen(onNavigateToAboutScreen = { navController.navigate("aboutScreen") }) }
        composable("aboutScreen") { AboutScreen(onNavigateToLoginScreen = { navController.navigate("loginScreen") }) }
    }
}