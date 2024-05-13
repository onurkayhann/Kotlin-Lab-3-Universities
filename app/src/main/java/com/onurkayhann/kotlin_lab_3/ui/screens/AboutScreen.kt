package com.onurkayhann.kotlin_lab_3.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.onurkayhann.kotlin_lab_3.ui.components.CompanyLogo
import com.onurkayhann.kotlin_lab_3.ui.components.PrimaryBtn
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Blue80

@Composable
fun AboutScreen(navController: NavController) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBlue80)
            .verticalScroll(state = rememberScrollState())
    ) {

        CompanyLogo()

        Text(
            AnnotatedString("Welcome dear student! ") +
                    AnnotatedString("ErasmusBuddy", SpanStyle(color = Blue80, fontFamily = FontFamily(Font(R.font.poppins_extra_bold)))) +
                    AnnotatedString(" is a company that offers free Erasmus period") +
                    AnnotatedString(" abroad for you courageous students. For ") +
                    AnnotatedString("free", SpanStyle(color = Blue80, fontFamily = FontFamily(Font(R.font.poppins_extra_bold)))) +
                    AnnotatedString("!"),
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            fontSize = 20.sp,
            color = Color.White,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Light,
            lineHeight = 40.sp,
            modifier = Modifier.padding(16.dp),
        )

        Image(
            painter = painterResource(id = R.drawable.international_students),
            contentDescription = "International students",
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
        )
        
        Spacer(modifier = Modifier.height(30.dp))

        PrimaryBtn(
            text = "Go to Login",
            onClick = { navController.navigate("loginScreen") },
        )
    }

}