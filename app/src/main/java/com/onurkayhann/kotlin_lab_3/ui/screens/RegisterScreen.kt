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
import com.onurkayhann.kotlin_lab_3.ui.models.User
import com.onurkayhann.kotlin_lab_3.ui.models.users
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80

@Composable
fun RegisterScreen(onNavigateToLoginScreen: () -> Unit) {
    
    // user values
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(BlackBlue80)
    ) {

        Text(text = "Register")


        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Enter Username") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(10.dp)) // add line break

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(10.dp)) // add line break

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Confirm password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(10.dp)) // add line break

        Button(onClick = {
            if (username.isNotBlank() && password.isNotBlank() && password == confirmPassword) {
                users.add(User(username, password))
                println("user registered: $username")

                // loop through users
                for (user in users) {
                    println(user)
                }

                username = ""
                password = ""
                confirmPassword = ""

            } else {
                println("Password mismatch")
                // TODO: Toast
            }
        }) {
            Text(
                text = "Register",
                modifier = Modifier
                    .padding(horizontal = 100.dp, vertical = 5.dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Or Login",
            modifier = Modifier.clickable { onNavigateToLoginScreen() }
        )
    }
}