package com.example.listofworkers.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    private val BASE_URL:String = "https://gitlab.65apps.com/65gb/static/raw/master/"

     val retrofit = Retrofit.Builder()
     .addConverterFactory(GsonConverterFactory.create())
     .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
     .baseUrl(BASE_URL)
     .build()

     val apiService : ApiService = retrofit.create(ApiService::class.java)
}