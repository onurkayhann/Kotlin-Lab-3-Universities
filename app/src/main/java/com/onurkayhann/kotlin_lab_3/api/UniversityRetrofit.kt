package com.onurkayhann.kotlin_lab_3.api

import com.onurkayhann.kotlin_lab_3.ui.models.university.University
import com.onurkayhann.kotlin_lab_3.ui.models.university.UniversityApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object UniversityRetrofit {
    private const val BASE_URL = "http://universities.hipolabs.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val universityApi: UniversityApi by lazy {
        retrofit.create<UniversityApi>()
    }

    suspend fun fetchUniversity(country: String): List<University> {
        return suspendCoroutine { continuation ->
            universityApi.getUniversities(country).enqueue(object : Callback<List<University>> {

                override fun onResponse(call: Call<List<University>>, response: Response<List<University>>) {
                    if (response.isSuccessful) {
                        val university = response.body()
                        if (university != null) {
                            continuation.resume(university)
                        } else {
                            continuation.resumeWithException(Exception("Unsuccessful response: ${response.code()}"))
                        }
                    }
                }

                override fun onFailure(call: Call<List<University>>, t: Throwable) {
                    println(t.message)
                }
            })
        }
    }
}
