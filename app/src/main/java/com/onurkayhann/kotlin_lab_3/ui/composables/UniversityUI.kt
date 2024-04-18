package com.onurkayhann.kotlin_lab_3.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.onurkayhann.kotlin_lab_3.api.University
import com.onurkayhann.kotlin_lab_3.api.UniversityRetrofit
import com.onurkayhann.kotlin_lab_3.viewModels.UniversityViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun UniversityUI(viewModel: UniversityViewModel = viewModel()) {
    var country by remember { mutableStateOf("") } // State for user input

    Column {
        TextField(
            value = country,
            onValueChange = { country = it },
            label = { Text("Enter country") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { viewModel.fetchUniversityData(country) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Search")
        }

        LaunchedEffect(country) {
            if (country.isNotBlank()) {
                viewModel.fetchUniversityData(country)
            }
        }

        val universities = viewModel.universityUiState.value

        if (universities.isNotEmpty()) {
            for (university in universities) {
                Text(text = "Name: ${university.name}")
                Text(text = "Country: ${university.country}")
            }
        } else {
            Text(text = "Enter the country name to see available universities")
        }
    }
}