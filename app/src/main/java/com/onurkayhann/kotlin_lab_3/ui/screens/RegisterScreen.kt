package com.onurkayhann.kotlin_lab_3.ui.screens


import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
import com.onurkayhann.kotlin_lab_3.ui.models.User
import com.onurkayhann.kotlin_lab_3.ui.models.users
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Blue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Gray80

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun RegisterScreen(onNavigateToLoginScreen: () -> Unit) {

    // user values
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBlue80)
    ) {



        CompanyLogo()

        Text(
            text = "Register",
            fontFamily = FontFamily(Font(R.font.poppins_extra_bold)),
            fontSize = 30.sp,
            color = Blue80
        )


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

        Row(
            horizontalArrangement = Arrangement.Absolute.Center,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .width(10.dp)
        ) {

            MyBtn(
                text = "Register",
                onClick = {
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
                },
            )

            //Spacer(modifier = Modifier.height(15.dp))
            MyBtnTwo(text = "Or Login", onClick = { onNavigateToLoginScreen() }, backgroundColor = BlackBlue80)

        }


    }
}