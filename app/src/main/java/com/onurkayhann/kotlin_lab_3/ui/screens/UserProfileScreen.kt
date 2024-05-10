package com.onurkayhann.kotlin_lab_3.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.onurkayhann.kotlin_lab_3.ui.components.CompanyLogo
import com.onurkayhann.kotlin_lab_3.ui.models.user.UserRepository
import com.onurkayhann.kotlin_lab_3.ui.theme.BlackBlue80
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*
@Composable
fun UserProfileScreen(
    userId: Long,
    username: String,
    userRepository: UserRepository
) {

    var isEditing by remember { mutableStateOf(false) }
    var newUsername by remember { mutableStateOf(username) }
    var currentUsername by remember { mutableStateOf(username) }

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
            if (!isEditing) {
                Text(text = "Username: $currentUsername")
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Button(onClick = { isEditing = true }) {
                    Text(text = "Edit Username")
                }
            } else {
                // Editing mode
                OutlinedTextField(
                    value = newUsername,
                    onValueChange = { newUsername = it },
                    label = { Text("New Username") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = { isEditing = false }) {
                        Text(text = "Cancel")
                    }
                    Button(onClick = {
                        // Update username in the database
                        updateUsername(userId, newUsername, userRepository)
                        currentUsername = newUsername
                        isEditing = false
                    }) {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}
}

 */