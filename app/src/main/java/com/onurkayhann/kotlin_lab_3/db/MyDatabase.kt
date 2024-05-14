package com.onurkayhann.kotlin_lab_3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.onurkayhann.kotlin_lab_3.ui.models.university.University
import com.onurkayhann.kotlin_lab_3.ui.models.user.User
import com.onurkayhann.kotlin_lab_3.ui.models.user.UserDAO

@Database(entities = [User::class, University::class], version = 3)
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
                )
                    .addMigrations(MIGRATION_2_3)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        // Migration from version 2 to 3
        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {

                db.execSQL("DROP TABLE IF EXISTS universities")

                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS universities (" +
                            "name TEXT NOT NULL," +
                            "country TEXT NOT NULL," +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NULL" + // Ensure id is not nullable
                            ")"
                )

                // Add the universityList column to the users table
                db.execSQL("ALTER TABLE users ADD COLUMN universityList TEXT")
            }
        }
    }
    }