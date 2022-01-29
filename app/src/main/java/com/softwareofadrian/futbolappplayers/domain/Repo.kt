package com.softwareofadrian.futbolappplayers.domain

import com.softwareofadrian.futbolappplayers.data.model.Player
import com.softwareofadrian.futbolappplayers.vo.Resource

interface Repo {

    suspend fun getPlayersList(playerName: String): Resource<List<Player>>
}