package com.onurkayhann.kotlin_lab_3.ui.screens

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.onurkayhann.kotlin_lab_3.ui.composables.UniversityUI
import com.onurkayhann.kotlin_lab_3.viewModels.UniversityViewModel

@Composable
fun UniversityListScreen(universityViewModel: UniversityViewModel) {
    UniversityUI(universityViewModel)
}