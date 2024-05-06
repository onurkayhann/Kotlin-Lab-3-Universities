package com.onurkayhann.kotlin_lab_3.ui.models.university

import com.onurkayhann.kotlin_lab_3.api.University
import com.onurkayhann.kotlin_lab_3.db.MyDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class UniversityRepository(
    private val myDatabase: MyDatabase,
    private val coroutineScope: CoroutineScope
) {


    fun performDatabaseOperation(dispatcher: CoroutineDispatcher, databaseOperation: suspend () -> Unit) {
        coroutineScope.launch(dispatcher) {
            databaseOperation()
        }
    }
}