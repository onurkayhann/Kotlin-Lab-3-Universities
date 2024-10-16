package com.onurkayhann.kotlin_lab_3.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onurkayhann.kotlin_lab_3.R
import com.onurkayhann.kotlin_lab_3.ui.composables.CompanyLogo
import com.onurkayhann.kotlin_lab_3.ui.composables.PrimaryBtn
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Blue80

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun WelcomeScreen(navController: NavController) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBlue80)
    ) {

        CompanyLogo()

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(state = rememberScrollState())
        ) {

            Text(
                AnnotatedString("Welcome to ") +
                        AnnotatedString("ErasmusBuddy", SpanStyle(color = Blue80, fontFamily = FontFamily(Font(R.font.poppins_extra_bold)))) +
                        AnnotatedString("! This is the app for you courageous students") + AnnotatedString("! Click the button below to read more about this App"),
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontSize = 20.sp,
                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Light,
                lineHeight = 40.sp,
                modifier = Modifier.padding(16.dp),
            )

            PrimaryBtn(
                text = "Read More",
                onClick = { navController.navigate("aboutScreen") },
            )
        }

    }

}