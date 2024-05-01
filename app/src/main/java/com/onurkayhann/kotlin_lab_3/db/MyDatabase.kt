package com.onurkayhann.kotlin_lab_3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onurkayhann.kotlin_lab_3.ui.models.user.User
import com.onurkayhann.kotlin_lab_3.ui.models.user.UserDAO

@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDao() : UserDAO

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context : Context): MyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "my-app-db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}