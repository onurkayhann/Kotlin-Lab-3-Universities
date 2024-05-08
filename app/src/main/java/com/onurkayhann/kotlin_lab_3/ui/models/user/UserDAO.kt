package com.onurkayhann.kotlin_lab_3.ui.models.user

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.onurkayhann.kotlin_lab_3.api.University
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Upsert
    fun insertOrUpdateUser(user: User)

    @Query("SELECT * FROM users")
    fun findAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM users WHERE username = :username AND password = :password LIMIT 1")
    fun findUser(username: String, password: String): User?

    // comment this out if app crashes
    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: Long): User?

    // comment out if it crashes

    @Transaction
    suspend fun addUniversityToUser(userId: Long, university: University) {
        val user = getUserById(userId)
        if (user != null) {
            val updatedUniversityList = (user.universityList ?: mutableListOf()).toMutableList().apply {
                add(university)
            }
            val updatedUser = user.copy(universityList = updatedUniversityList)
            insertOrUpdateUser(updatedUser)
        }
    }

}