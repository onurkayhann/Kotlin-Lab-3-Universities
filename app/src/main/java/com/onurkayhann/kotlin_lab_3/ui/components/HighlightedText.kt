package com.onurkayhann.kotlin_lab_3.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.onurkayhann.kotlin_lab_3.ui.theme.Blue80

@Composable
fun HighlightedText(text: String) {
    Text(
        text = text,
        color = Blue80,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    )
}
