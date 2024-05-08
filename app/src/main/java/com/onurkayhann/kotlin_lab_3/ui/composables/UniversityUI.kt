package com.onurkayhann.kotlin_lab_3.ui.composables

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.onurkayhann.kotlin_lab_3.viewModels.UniversityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.onurkayhann.kotlin_lab_3.api.University
import com.onurkayhann.kotlin_lab_3.ui.components.PrimaryBtn
import com.onurkayhann.kotlin_lab_3.ui.components.SecondaryBtn
import com.onurkayhann.kotlin_lab_3.ui.models.user.User
import com.onurkayhann.kotlin_lab_3.ui.models.user.UserRepository
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Blue80
import com.onurkayhann.kotlin_lab_3.ui.theme.Gray80
import com.onurkayhann.kotlin_lab_3.ui.theme.White80
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun UniversityUI(
    viewModel: UniversityViewModel = viewModel(),
    userRepository: UserRepository,
    username: String,
) { // comment out if it crashes
    var country by remember { mutableStateOf("") } // State for user input
    val coroutineScope = rememberCoroutineScope()

    // user values
    var password by remember { mutableStateOf("") }
    val universityList = remember { mutableStateOf(mutableListOf<University>()) } // State for user's university list

    fun handleLogin(newUsername: String, newPassword: String, universityList: MutableList<University>?) {
        coroutineScope.launch(Dispatchers.IO) {
            // Perform database operations here
            // For example, update username and password
            userRepository.insertOrUpdateUser(User(newUsername, newPassword, universityList))
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
        OutlinedTextField(
            value = country,
            onValueChange = { country = it },
            label = { Text("Which country do you want to study in") },
            textStyle = TextStyle(color = Blue80),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Blue80,
                unfocusedBorderColor = Gray80,
                focusedContainerColor = Gray80,
                unfocusedContainerColor = Gray80
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
        PrimaryBtn(text = "Search", onClick = { viewModel.fetchUniversityData(country) })


        LaunchedEffect(country) {
            if (country.isNotBlank()) {
                viewModel.fetchUniversityData(country)
            }
        }

        val universities = viewModel.universityUiState.value

        // Display message if there are no universities or if country is not entered yet
        if (universities.isEmpty() && country.isNotBlank()) {
            Text(
                text = "No universities found for the entered country.",
                color = White80,
                modifier = Modifier.padding(vertical = 8.dp),
            )
        } else if (country.isBlank()) {
            Text(
                text = "Enter the country name to see available universities",
                color = White80,
                modifier = Modifier.padding(vertical = 8.dp),
            )
        }

        LazyColumn {
            items(universities) { university ->
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
                        Text(text = "Name: ${university.name}", color = White80)
                        Text(text = "Country: ${university.country}", color = White80)
                        Row(
                            horizontalArrangement = Arrangement.Absolute.Center,
                            verticalAlignment = Alignment.Top,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp)
                        ) {
                            PrimaryBtn(text = "Enroll", onClick = {
                                coroutineScope.launch(Dispatchers.IO) {
                                    // Find user by username
                                    val currentUser = userRepository.findUser(username, password)


                                    if (currentUser != null) {
                                        // Add university to user's universityList
                                        userRepository.addUniversityToUser(currentUser.id ?: -1, university)
                                        println("University $university added to user $username's list")
                                    } else {
                                        println("Couldn't add university to $username")
                                    }
                                }
                            })
                            Spacer(modifier = Modifier.width(8.dp))
                            SecondaryBtn(text = "Info", onClick = { /* TODO */ })
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
