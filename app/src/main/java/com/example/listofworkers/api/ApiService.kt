package com.example.listofworkers.api

import androidx.lifecycle.LiveData
import com.example.listofworkers.pojo.ListOfWorkers
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("testTask.json")
    fun getListOfWorkers () : Single<ListOfWorkers>
}