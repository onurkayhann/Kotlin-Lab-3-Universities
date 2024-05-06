package com.onurkayhann.kotlin_lab_3.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.onurkayhann.kotlin_lab_3.api.University

object Converters {
    @TypeConverter
    @JvmStatic
    fun fromUniversityList(universityList: MutableList<University>): String {
        return Gson().toJson(universityList)
    }

    @TypeConverter
    @JvmStatic
    fun toUniversityList(universityListString: String): MutableList<University> {
        val type = object : TypeToken<MutableList<University>>() {}.type
        return Gson().fromJson(universityListString, type)
    }
}