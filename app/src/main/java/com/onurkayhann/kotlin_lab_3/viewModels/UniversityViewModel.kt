package com.onurkayhann.kotlin_lab_3.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onurkayhann.kotlin_lab_3.api.University
import com.onurkayhann.kotlin_lab_3.api.UniversityRetrofit
import kotlinx.coroutines.launch

class UniversityViewModel : ViewModel() {
    var universityUiState: MutableState<List<University>> = mutableStateOf(emptyList())

    fun fetchUniversityData(country: String) {
        viewModelScope.launch {
            try {
                val universities = UniversityRetrofit.fetchUniversity(country)
                universityUiState.value = universities
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}