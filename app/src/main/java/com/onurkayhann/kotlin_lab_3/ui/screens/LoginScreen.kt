package com.onurkayhann.kotlin_lab_3.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onurkayhann.kotlin_lab_3.R
import com.onurkayhann.kotlin_lab_3.ui.components.CompanyLogo
import com.onurkayhann.kotlin_lab_3.ui.components.MyBtn
import com.onurkayhann.kotlin_lab_3.ui.components.MyBtnTwo
import com.onurkayhann.kotlin_lab_3.ui.models.users
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Blue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Gray40
import com.onurkayhann.kotlin_lab_3.ui.theme.Gray80
import com.onurkayhann.kotlin_lab_3.ui.theme.White80

@Composable
fun LoginScreen(onNavigateToRegisterScreen: () -> Unit, onNavigateToLoggedInScreen: (String) -> Unit) {

    // user values
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // function for login && checking if username/password matches
    fun userLogin() {
        val user = users.find { it.username == username && it.password == password }

        if (user != null) {
            println("Login successful for user: $username")
            onNavigateToLoggedInScreen(username)
        } else {
            println("Invalid username or password")
        }
    }

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
                text = "Login",
                fontFamily = FontFamily(Font(R.font.poppins_extra_bold)),
                fontSize = 30.sp,
                color = Color.White
            )
            Card(
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(2.dp, Gray80),
                colors = CardDefaults.cardColors(
                    containerColor = Gray80.copy(alpha = 0.85f),
                ),
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .shadow(16.dp)
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                ) {

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text(text = "Enter username") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                        textStyle = TextStyle(color = Color.White),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Blue80,
                            focusedContainerColor = BlackBlue80,
                            unfocusedContainerColor = BlackBlue80
                        ),
                        shape = RoundedCornerShape(25.dp),
                        modifier = Modifier
                            .width(320.dp)
                            .padding(vertical = 10.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp)) // add line break

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "Enter password") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        textStyle = TextStyle(color = Blue80),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Blue80,
                            focusedContainerColor = BlackBlue80,
                            unfocusedContainerColor = BlackBlue80
                        ),
                        shape = RoundedCornerShape(25.dp),
                        modifier = Modifier
                            .width(320.dp)
                            .padding(bottom = 10.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        horizontalArrangement = Arrangement.Absolute.Center,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp)
                    ) {
                        MyBtn(
                            text = "Login",
                            onClick = { userLogin() },
                        )

                        MyBtnTwo(
                            text = "Sign Up",
                            onClick = { onNavigateToRegisterScreen() },
                            backgroundColor = Gray40
                        )

                    }
                }

            }
        }

    }
}

