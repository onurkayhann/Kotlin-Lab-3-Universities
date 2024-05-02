package com.onurkayhann.kotlin_lab_3.ui.navigator

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.onurkayhann.kotlin_lab_3.ui.models.user.UserRepository
import com.onurkayhann.kotlin_lab_3.ui.screens.AboutScreen
import com.onurkayhann.kotlin_lab_3.ui.screens.LoggedInScreen
import com.onurkayhann.kotlin_lab_3.ui.screens.LoginScreen
import com.onurkayhann.kotlin_lab_3.ui.screens.RegisterScreen
import com.onurkayhann.kotlin_lab_3.ui.screens.WelcomeScreen

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Home(userRepository: UserRepository) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcomeScreen") {
        composable("welcomeScreen") { WelcomeScreen(navController) }
        composable("aboutScreen") { AboutScreen(navController) }
        composable("registerScreen") { RegisterScreen(navController, userRepository) }
        composable("loginScreen") {
            LoginScreen(navController, userRepository)
        }
        composable("loggedInScreen/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username")
            username?.let { LoggedInScreen(username = it) }
        }
    }
}