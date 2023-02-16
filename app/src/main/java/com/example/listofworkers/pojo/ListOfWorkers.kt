package com.example.listofworkers.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ListOfWorkers (
    @SerializedName("response")
    @Expose
     var response: List<Worker>
    )