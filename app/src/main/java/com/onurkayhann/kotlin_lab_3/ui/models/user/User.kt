package com.onurkayhann.kotlin_lab_3.ui.models.user

import androidx.compose.runtime.mutableStateListOf
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.onurkayhann.kotlin_lab_3.api.University
import com.onurkayhann.kotlin_lab_3.db.Converters

// User
@Entity(tableName = "users")
@TypeConverters(Converters::class)
data class User(
    val username: String,
    val password: String,
    val universityList: MutableList<University>? = null // if app crashes, comment this section out
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}

// User List
val users = mutableStateListOf<User>()