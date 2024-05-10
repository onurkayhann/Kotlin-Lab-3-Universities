package com.onurkayhann.kotlin_lab_3.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

    val userIdState: MutableState<Long?> = remember { mutableStateOf(null) }

    LaunchedEffect(key1 = Unit) {
        val userId = userRepository.getLoggedInUserId()
        userIdState.value = userId
    }

    val userId = userIdState.value ?: -1L


    UniversityUI(universityViewModel, userRepository, username, userId  /* <-- delete if crashes */)
}

