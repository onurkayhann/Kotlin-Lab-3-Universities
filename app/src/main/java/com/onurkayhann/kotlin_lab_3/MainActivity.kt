package com.onurkayhann.kotlin_lab_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.onurkayhann.kotlin_lab_3.ui.composables.UniversityUI
import com.onurkayhann.kotlin_lab_3.ui.navigator.Home
import com.onurkayhann.kotlin_lab_3.ui.theme.KotlinLab3Theme
import com.onurkayhann.kotlin_lab_3.viewModels.UniversityViewModel


class MainActivity : ComponentActivity() {
    private val universityViewModel by viewModels<UniversityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLab3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // UniversityUI(universityViewModel) // This calls all the apis
                    Home()
                }
            }
        }
    }
}


/*
 *  TODO:
 *      - add reusable buttons to all screens
 *      - create card for forms✅
 *      - add reusable cards next to each other as in RegisterScreen, do the same for LoginScreen✅
 *      - change MyBtn to PrimaryBtn and MyBtnTwo to SecondaryBtn
 *      - add icons to input fields
 *      - font✅
 *      - logo✅
 *      - email for users?
 *      - theme
 *      - connect to database --> RoomDB or Firebase --> Entity?? Ask Kristoffer!
 *      - user must be able to add, delete and edit
 *      - colors✅
 *      - user shouldn't be able to register with existing username
 *      - add darker gray or shadow?
 *      - make card with less width, also blue button with less width
*/