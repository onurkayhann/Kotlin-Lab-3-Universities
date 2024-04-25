package com.onurkayhann.kotlin_lab_3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.onurkayhann.kotlin_lab_3.ui.components.MyBtn
import com.onurkayhann.kotlin_lab_3.ui.models.users
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Blue80

@Composable
fun LoginScreen(onNavigateToRegisterScreen: () -> Unit, onNavigateToLoggedInScreen: (String) -> Unit) {

    // user values
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(BlackBlue80)
    ) {

        Text(text = "Login")


        Spacer(modifier = Modifier.height(10.dp))

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

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Enter username") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(10.dp)) // add line break

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(10.dp))

        MyBtn(
            text = "Login",
            onClick = { userLogin() },
        )

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Or Register",
            modifier = Modifier.clickable { onNavigateToRegisterScreen() }
        )
    }
    }

