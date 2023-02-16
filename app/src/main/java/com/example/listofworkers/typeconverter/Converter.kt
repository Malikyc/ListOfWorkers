package com.example.listofworkers.typeconverter

import androidx.room.TypeConverter
import com.example.listofworkers.pojo.Specialty
import com.google.gson.Gson

class Converter {

    @TypeConverter
    fun getStringFromSpec(list: List<Specialty>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun getSpecFromString(string: String): List<Specialty> {
        val gson = Gson()
        val objects = gson.fromJson(string,ArrayList::class.java)
        var specialties = mutableListOf<Specialty>()
        for (i in objects){
            specialties.add(gson.fromJson(i.toString(),Specialty::class.java))
        }
        return specialties
    }
}