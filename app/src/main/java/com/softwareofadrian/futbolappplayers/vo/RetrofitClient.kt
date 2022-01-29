package com.softwareofadrian.futbolappplayers.vo

import com.google.gson.GsonBuilder
import com.softwareofadrian.futbolappplayers.domain.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    //este object sirve para crear e usar una instancia de retrofi
    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}