package com.softwareofadrian.futbolappplayers.domain

import com.softwareofadrian.futbolappplayers.data.model.PlayerList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("searchplayers.php?p=")
    suspend fun getPlayerByName(@Query("p") playerName: String): PlayerList
}