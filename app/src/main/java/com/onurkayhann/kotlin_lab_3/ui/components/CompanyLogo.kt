package com.onurkayhann.kotlin_lab_3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.onurkayhann.kotlin_lab_3.R

@Composable
fun CompanyLogo() {
    val logo = painterResource(id = R.drawable.logo)

    Image(painter = logo, contentDescription = "Erasmus Buddy logo")
}