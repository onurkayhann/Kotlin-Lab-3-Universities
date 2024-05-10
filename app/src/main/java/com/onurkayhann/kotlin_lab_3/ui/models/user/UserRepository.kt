package com.onurkayhann.kotlin_lab_3.ui.models.user

import com.onurkayhann.kotlin_lab_3.api.University
import com.onurkayhann.kotlin_lab_3.db.MyDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserRepository(
    private val myDatabase: MyDatabase,
    private val coroutineScope: CoroutineScope
) {

    fun addUniversityToUserIfMatching(userId: Long, university: University, username: String) {
        coroutineScope.launch(Dispatchers.IO) {
            myDatabase.userDao().addUniversityToUserIfMatching(userId, university, username)
        }
    }

    var loggedInUserId: Long = -1 // Default value indicating no logged-in user

    // SAVE USER
    fun insertOrUpdateUser(user: User) {
        myDatabase.userDao().insertOrUpdateUser(user)
    }

    // FIND USER BY USERNAME && PASSWORDS
    fun findUser(username: String, password: String): User? {
        return myDatabase.userDao().findUser(username, password)
    }

    // GET USER BY ID
    suspend fun getUserById(userId: Long): User? {
        return myDatabase.userDao().getUserById(userId)
    }

    // Method to set the logged-in user's ID
    suspend fun setLoggedInUserId(userId: Long) {
        loggedInUserId = userId
    }

    // Method to get the logged-in user's ID
    suspend fun getLoggedInUserId(): Long {
        return loggedInUserId
    }


    fun findAllUsers(): Flow<List<User>> {
        return myDatabase.userDao().findAllUsers()
    }

    // comment out if it crashes
    suspend fun addUniversityToUser(userId: Long, university: University) {
        coroutineScope.launch {
            myDatabase.userDao().addUniversityToUser(userId, university)
        }
    }


    suspend fun addUniversityToUserTwo(user: User, university: University) {
        coroutineScope.launch {
            myDatabase.userDao().updateUser(user)
            myDatabase.userDao().addUniversityToUserTwo(user, university)
        }
    }
    suspend fun addUniversityToUserTwo(user: User, university: University, username: String) {
        user.universityList?.add(university)
        myDatabase.userDao().updateUser(user)
    }

    suspend fun updateUsername(userId: Long, newUsername: String) {
        myDatabase.userDao().updateUsername(userId, newUsername)
    }

    suspend fun findUserByUsername(username: String): User? {
        return myDatabase.userDao().findUserByUsername(username)
    }

    suspend fun findUserByUsernameAndId(username: String, userId: Long): User? {
        return myDatabase.userDao().findUserByUsernameAndId(username, userId)
    }


    suspend fun updateUser(user: User) {
        myDatabase.userDao().updateUser(user)
    }

    suspend fun updateUniversity(university: University) {
        myDatabase.userDao().updateUniversity(university)
    }

    fun performDatabaseOperation(dispatcher: CoroutineDispatcher, databaseOperation: suspend () -> Unit) {
        coroutineScope.launch(dispatcher) {
            databaseOperation()
        }
    }

}