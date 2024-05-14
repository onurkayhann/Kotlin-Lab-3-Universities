package com.onurkayhann.kotlin_lab_3.ui.models.university

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityApi {

    @GET("/search")
    fun getUniversities(@Query("country") country: String): Call<List<University>>
}