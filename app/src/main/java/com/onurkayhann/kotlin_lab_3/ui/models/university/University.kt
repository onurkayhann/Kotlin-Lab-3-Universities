package com.onurkayhann.kotlin_lab_3.ui.models.university

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "universities")
data class University(
    val name: String,
    val country: String,
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
)