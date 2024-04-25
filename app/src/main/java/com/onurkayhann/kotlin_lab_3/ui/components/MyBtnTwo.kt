package com.onurkayhann.kotlin_lab_3.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onurkayhann.kotlin_lab_3.R
import com.onurkayhann.kotlin_lab_3.ui.theme.Gray80

@Composable
fun MyBtnTwo(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor),
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .width(120.dp)
            .height(50.dp)
            .border(1.dp, color = Gray80, shape = RoundedCornerShape(20.dp))
    ) {
        Text(
            text = text,
            color = Gray80,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.poppins_regular))
        )
    }
}