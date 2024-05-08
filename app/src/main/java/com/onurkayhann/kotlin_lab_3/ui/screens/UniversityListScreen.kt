package com.onurkayhann.kotlin_lab_3.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import com.onurkayhann.kotlin_lab_3.ui.composables.UniversityUI
import com.onurkayhann.kotlin_lab_3.ui.models.user.UserRepository
import com.onurkayhann.kotlin_lab_3.viewModels.UniversityViewModel

// choose below if app crashes
@Composable
fun UniversityListScreen(
    universityViewModel: UniversityViewModel,
    userRepository: UserRepository,
    username: String,
) {
    val coroutineScope = rememberCoroutineScope() // Remember the coroutine scope

    UniversityUI(universityViewModel, userRepository, username)
}

