package com.onurkayhann.kotlin_lab_3

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.onurkayhann.kotlin_lab_3.db.MyDatabase
import com.onurkayhann.kotlin_lab_3.ui.models.user.UserRepository
import com.onurkayhann.kotlin_lab_3.ui.navigator.Home
import com.onurkayhann.kotlin_lab_3.ui.theme.KotlinLab3Theme
import com.onurkayhann.kotlin_lab_3.viewModels.UniversityViewModel


class MainActivity : ComponentActivity() {
    private val universityViewModel by viewModels<UniversityViewModel>()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize database and userRepository

        // Variables
        val db = MyDatabase.getInstance(applicationContext)
        val userRepository = UserRepository(db, lifecycleScope)


        // Run Logic
        println(applicationContext.getDatabasePath("my-app-db"))


        setContent {
            KotlinLab3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home(userRepository, universityViewModel, applicationContext, db, lifecycleScope)
                }
            }
        }
    }
}


/*
 *  TODO:
 *      - email for users?
 *      - theme
 *      - user must be able to add, delete and edit
 *      - user shouldn't be able to register with existing username
 *      - make card with less width, also blue button with less width
 *      - SignedInScreen:
 *          --> Trending Universities (show 5 randomly universities) with cards moving automatically to the left
 *          --> button for Edit Profile,
 *          --> button for Explore Universities,
 *          --> and there should universities be rendered with search input field
 *          --> Add User Profile Picture? Instead of CompanyLogo
 *      - add right arrow to 'Read More' and 'Go to Login' button
 *      - delete UniversityDAO and UniversityRepository?
*/