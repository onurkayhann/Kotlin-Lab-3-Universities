package com.onurkayhann.kotlin_lab_3.ui.models.user

import androidx.compose.runtime.mutableStateListOf
import androidx.room.Entity
import androidx.room.PrimaryKey

// User
@Entity(tableName = "users")
data class User(
    val username: String,
    val password: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

// User List
val users = mutableStateListOf<User>()