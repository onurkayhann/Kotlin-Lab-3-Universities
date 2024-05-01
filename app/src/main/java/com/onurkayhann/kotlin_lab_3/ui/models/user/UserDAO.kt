package com.onurkayhann.kotlin_lab_3.ui.models.user

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Upsert
    fun insertOrUpdateUser(user: User)

    @Query("SELECT * FROM users")
    fun findAllUsers(): Flow<List<User>>
}