package com.onurkayhann.kotlin_lab_3.ui.screens


import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.onurkayhann.kotlin_lab_3.R
import com.onurkayhann.kotlin_lab_3.ui.composables.CompanyLogo
import com.onurkayhann.kotlin_lab_3.ui.composables.PrimaryBtn
import com.onurkayhann.kotlin_lab_3.ui.composables.SecondaryBtn
import com.onurkayhann.kotlin_lab_3.ui.models.user.User
import com.onurkayhann.kotlin_lab_3.ui.models.user.UserRepository
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Blue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Gray80
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
// @RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun RegisterScreen(
    navController: NavController,
    userRepository: UserRepository,
    context: Context
) {

    // user values
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    // Get the current coroutine scope
    val coroutineScope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBlue80)
            .padding(vertical = 10.dp)
            .verticalScroll(state = rememberScrollState())
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
            text = "Register",
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
                    .padding(horizontal = 25.dp)
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "",
                            tint = Blue80
                        )
                    },
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Enter Username") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                    textStyle = TextStyle(color = Color.White),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Blue80,
                        unfocusedBorderColor = BlackBlue80,
                        focusedContainerColor = BlackBlue80,
                        unfocusedContainerColor = BlackBlue80,
                    ),
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .width(320.dp)
                )

                Spacer(modifier = Modifier.height(10.dp)) // add line break

                OutlinedTextField(
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = "",
                            tint = Blue80
                        )
                    },
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Enter Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    textStyle = TextStyle(color = Blue80),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Blue80,
                        unfocusedBorderColor = BlackBlue80,
                        focusedContainerColor = BlackBlue80,
                        unfocusedContainerColor = BlackBlue80
                    ),
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .width(320.dp)
                )

                Spacer(modifier = Modifier.height(10.dp)) // add line break

                OutlinedTextField(
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = "",
                            tint = Blue80
                        )
                    },
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text(text = "Confirm password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    textStyle = TextStyle(color = Blue80),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Blue80,
                        unfocusedBorderColor = BlackBlue80,
                        focusedContainerColor = BlackBlue80,
                        unfocusedContainerColor = BlackBlue80
                    ),
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .width(320.dp)
                )

                Spacer(modifier = Modifier.height(10.dp)) // add line break
            }


            Row(
                horizontalArrangement = Arrangement.Absolute.Center,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            ) {

                PrimaryBtn(
                    text = "Register",
                    onClick = {
                        coroutineScope.launch { // Launch a coroutine
                            if (username.isNotBlank() && password.isNotBlank() && password == confirmPassword) {
                                // Check if username already exists
                                val existingUser = userRepository.findUserByUsername(username)
                                if (existingUser == null) {
                                    // If username is unique, register the user
                                    userRepository.performDatabaseOperation(Dispatchers.IO) {
                                        val user = User(username, password, null)
                                        userRepository.insertOrUpdateUser(user)
                                        println("user registered: $username")

                                        username = ""
                                        password = ""
                                        confirmPassword = ""

                                        // Show toast message on the main/UI thread
                                        withContext(Dispatchers.Main) {
                                            Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show()
                                        }

                                        // Find all users
                                        userRepository.performDatabaseOperation(Dispatchers.Main) {
                                            userRepository.findAllUsers().collect {
                                                println(it)
                                            }
                                        }
                                    }
                                } else {
                                    // If username already exists, show an error message
                                    println("Username already exists")
                                    // Show toast message on the main/UI thread
                                    withContext(Dispatchers.Main) {
                                        Toast.makeText(context, "Username already exists", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            } else {
                                println("Password mismatch")
                                // Show toast message on the main/UI thread
                                withContext(Dispatchers.Main) {
                                    Toast.makeText(context, "Password mismatch", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }
                )

                SecondaryBtn(text = "Or Login", onClick = { navController.navigate("loginScreen") })

            }
        }
    }

    }
}


