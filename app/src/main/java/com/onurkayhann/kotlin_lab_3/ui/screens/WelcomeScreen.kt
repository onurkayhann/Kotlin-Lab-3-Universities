package com.onurkayhann.kotlin_lab_3.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.onurkayhann.kotlin_lab_3.R
import com.onurkayhann.kotlin_lab_3.ui.components.CompanyLogo
import com.onurkayhann.kotlin_lab_3.ui.components.MyBtn
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Blue80

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun WelcomeScreen(onNavigateToAboutScreen: () -> Unit) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBlue80)
    ) {

        CompanyLogo()

        Column(
            verticalArrangement = Arrangement.Center, // Center the text vertically
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp) // Add padding
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

            MyBtn(
                text = "Navigate to AboutScreen",
                onClick = { onNavigateToAboutScreen() },
                backgroundColor = Blue80
            )
        }

    }

}