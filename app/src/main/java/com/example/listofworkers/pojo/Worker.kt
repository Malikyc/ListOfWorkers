package com.example.listofworkers.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.listofworkers.typeconverter.Converter
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



@Entity(tableName = "worker_info_list")
@TypeConverters(Converter::class)
data class Worker (
    @PrimaryKey(autoGenerate = true)
     var id: Int,
    @SerializedName("f_name")
    @Expose
     var fName: String? = null,
    @SerializedName("l_name")
    @Expose
     var lName: String? = null,
    @SerializedName("birthday")
    @Expose
    var birthday: String? = null,
    @SerializedName("avatr_url")
    @Expose
    var avatrUrl: String? = null,
    @SerializedName("specialty")
    @Expose
    var specialty: List<Specialty>
)
