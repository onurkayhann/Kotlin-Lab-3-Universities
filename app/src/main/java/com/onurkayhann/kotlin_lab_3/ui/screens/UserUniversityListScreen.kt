package com.onurkayhann.kotlin_lab_3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onurkayhann.kotlin_lab_3.R
import com.onurkayhann.kotlin_lab_3.ui.components.CompanyLogo
import com.onurkayhann.kotlin_lab_3.ui.models.user.User
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80

@Composable
fun UserUniversityListScreen(user: User) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBlue80)
            .padding(vertical = 10.dp)
    ) {

        CompanyLogo()

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 80.dp)
                .background(BlackBlue80)
        ) {
            Text(
                text = "You applied to:",
                fontFamily = FontFamily(Font(R.font.poppins_extra_bold)),
                fontSize = 30.sp,
                color = Color.White
            )

            LazyColumn {
                items(user.universityList ?: emptyList()) { university ->
                    Text(text = "${university.name} (${university.country})")
                }
            }
        }
    }
}