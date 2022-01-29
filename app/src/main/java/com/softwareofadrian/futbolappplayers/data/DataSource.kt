package com.softwareofadrian.futbolappplayers.data

import com.softwareofadrian.futbolappplayers.data.model.Player
import com.softwareofadrian.futbolappplayers.vo.Resource
import com.softwareofadrian.futbolappplayers.vo.RetrofitClient

class DataSource {

    suspend fun getPlayerByName(playerName: String): Resource<List<Player>> {
        return Resource.Success(RetrofitClient.webservice.getPlayerByName(playerName).playerList)
    }
}