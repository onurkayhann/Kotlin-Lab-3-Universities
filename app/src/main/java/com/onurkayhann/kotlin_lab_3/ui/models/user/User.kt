package com.onurkayhann.kotlin_lab_3.ui.models.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.onurkayhann.kotlin_lab_3.ui.models.university.University
import com.onurkayhann.kotlin_lab_3.db.Converters

// User
@Entity(tableName = "users")
@TypeConverters(Converters::class)
data class User(
    var username: String,
    val password: String,
    val universityList: MutableList<University>? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}