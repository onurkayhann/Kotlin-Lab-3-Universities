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
import com.onurkayhann.kotlin_lab_3.ui.screens.UniversityListScreen
import com.onurkayhann.kotlin_lab_3.ui.screens.WelcomeScreen
import com.onurkayhann.kotlin_lab_3.viewModels.UniversityViewModel
import android.content.Context
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleCoroutineScope
import com.onurkayhann.kotlin_lab_3.db.MyDatabase
import com.onurkayhann.kotlin_lab_3.ui.composables.UniversityUI
import com.onurkayhann.kotlin_lab_3.ui.models.user.User
import com.onurkayhann.kotlin_lab_3.ui.screens.UserUniversityListScreen

// import com.onurkayhann.kotlin_lab_3.ui.screens.UserProfileScreen

// import com.onurkayhann.kotlin_lab_3.ui.screens.UserProfileScreen


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Home(
    userRepository: UserRepository,
    universityViewModel: UniversityViewModel,
    context: Context,
    db: MyDatabase,
    lifecycleScope: LifecycleCoroutineScope
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcomeScreen") {
        composable("welcomeScreen") { WelcomeScreen(navController) }
        composable("aboutScreen") { AboutScreen(navController) }
        composable("registerScreen") { RegisterScreen(navController, userRepository, context) }
        composable("loginScreen") { LoginScreen(navController, userRepository, context) }


        composable("UniversityListScreen/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username")
            username?.let {
                UniversityListScreen(universityViewModel, userRepository, it, navController)
            }
        }

        composable("loggedInScreen/{username}") { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username")
            username?.let { LoggedInScreen(navController, username = it) }
        }

    }
}