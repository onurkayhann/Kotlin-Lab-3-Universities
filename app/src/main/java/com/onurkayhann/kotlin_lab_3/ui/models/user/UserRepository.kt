package com.onurkayhann.kotlin_lab_3.ui.models.user

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


    fun findAllUsers(): Flow<List<User>> {
        return myDatabase.userDao().findAllUsers()
    }

    fun performDatabaseOperation(dispatcher: CoroutineDispatcher, databaseOperation: suspend () -> Unit) {
        coroutineScope.launch(dispatcher) {
            databaseOperation()
        }
    }

}