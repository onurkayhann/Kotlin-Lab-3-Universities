package com.onurkayhann.kotlin_lab_3.ui.models

import androidx.compose.runtime.mutableStateListOf

// User
data class User(
    val username: String,
    val password: String,
)

// User List
val users = mutableStateListOf<User>()