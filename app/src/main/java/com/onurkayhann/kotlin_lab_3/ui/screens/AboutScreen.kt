package com.onurkayhann.kotlin_lab_3.ui.screens

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80

@Composable
fun AboutScreen(onNavigateToLoginScreen: () -> Unit) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(BlackBlue80)
    ) {

        Text(
            text = "Welcome to ErasmusBuddy",
            fontSize = 30.sp,
            modifier = Modifier.padding(16.dp)
        )

        Button(onClick = { onNavigateToLoginScreen() }) {
            Text(
                text = "Navigate to LoginScreen",
                modifier = Modifier
                    .padding(horizontal = 5.dp, vertical = 5.dp)
            )
        }
    }

}