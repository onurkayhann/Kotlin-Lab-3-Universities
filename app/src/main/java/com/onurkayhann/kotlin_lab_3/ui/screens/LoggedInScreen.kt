package com.onurkayhann.kotlin_lab_3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.onurkayhann.kotlin_lab_3.ui.components.CompanyLogo
import com.onurkayhann.kotlin_lab_3.ui.components.PrimaryBtn
import com.onurkayhann.kotlin_lab_3.ui.components.SecondaryBtn
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Blue80

@Composable
fun LoggedInScreen(navController: NavController, username: String) {

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
                AnnotatedString("Welcome to your profile dear ") +
                        AnnotatedString(
                            username, SpanStyle(
                                color = Blue80, fontFamily = FontFamily(
                                    Font(R.font.poppins_extra_bold)
                                )
                            )
                        ) +
                        AnnotatedString("! Below you can see the trending universities") + AnnotatedString(
                    "! Click one of the buttons below to Explore Universities or Edit your Profile."
                ),
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontSize = 20.sp,
                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Light,
                lineHeight = 40.sp,
                modifier = Modifier.padding(16.dp),
            )

            Spacer(modifier = Modifier.height(10.dp))


            Row(
                horizontalArrangement = Arrangement.Absolute.Center,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            ) {
                PrimaryBtn(
                    text = "Find Universities",
                    onClick = { navController.navigate("universityListScreen/$username") },
                )

                SecondaryBtn(
                    text = "Profile",
                    onClick = { navController.navigate("userProfileScreen/$username") },
                )
            }
        }
    }
}