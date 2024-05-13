package com.onurkayhann.kotlin_lab_3.ui.models.user

import androidx.core.view.OneShotPreDrawListener.add
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import androidx.room.Upsert
import com.onurkayhann.kotlin_lab_3.api.University
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Update
    suspend fun updateUsername(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Update
    suspend fun updateUniversity(university: University)


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
            // Update the user with the new university list
            updateUser(user.copy(universityList = updatedUniversityList))
        }
    }

    @Transaction
    suspend fun addUniversityToUserTwo(user: User, university: University) {
            val updatedUniversityList = (user.universityList ?: mutableListOf()).toMutableList().apply {
                add(university)
            }
            val updatedUser = user.copy(universityList = updatedUniversityList)
            insertOrUpdateUser(updatedUser)
        }

    @Transaction
    suspend fun addUniversityToUserThree(userId: Long, university: University) {
        val user = getUserById(userId)
        if (user != null) {
            val updatedUniversityList = (user.universityList ?: mutableListOf()).toMutableList().apply {
                add(university)
            }
            val updatedUser = user.copy(universityList = updatedUniversityList)
            insertOrUpdateUser(updatedUser)
        }
    }



    @Transaction
    suspend fun addUniversityToUserIfMatching(userId: Long, university: University, username: String) {
        val user = getUserById(userId)
        if (user != null && user.username == username) {
            val updatedUniversityList = (user.universityList ?: mutableListOf()).toMutableList().apply {
                add(university)
            }
            val updatedUser = user.copy(universityList = updatedUniversityList)
            insertOrUpdateUser(updatedUser)
        } else {
            println("User $username not found or ID doesn't match")
        }
    }


    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun findUserByUsername(username: String): User?

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    suspend fun getCurrentUser(username: String): User?

    @Query("SELECT * FROM users WHERE username = :username AND id = :userId")
    suspend fun findUserByUsernameAndId(username: String, userId: Long): User?

    // Delete if app crashes

    @Query("UPDATE users SET username = :newUsername WHERE id = :userId")
    suspend fun updateUsername(userId: Long, newUsername: String)

}