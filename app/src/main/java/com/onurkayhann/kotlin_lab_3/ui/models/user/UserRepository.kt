package com.onurkayhann.kotlin_lab_3.ui.models.user

import com.onurkayhann.kotlin_lab_3.api.University
import com.onurkayhann.kotlin_lab_3.db.MyDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserRepository(
    private val myDatabase: MyDatabase,
    private val coroutineScope: CoroutineScope
) {

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


    fun findAllUsers(): Flow<List<User>> {
        return myDatabase.userDao().findAllUsers()
    }

    // comment out if it crashes
    suspend fun addUniversityToUser(userId: Long, university: University) {
        coroutineScope.launch {
            myDatabase.userDao().addUniversityToUser(userId, university)
        }
    }

    fun performDatabaseOperation(dispatcher: CoroutineDispatcher, databaseOperation: suspend () -> Unit) {
        coroutineScope.launch(dispatcher) {
            databaseOperation()
        }
    }

}