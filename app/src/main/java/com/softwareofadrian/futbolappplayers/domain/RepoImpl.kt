package com.softwareofadrian.futbolappplayers.domain

import com.softwareofadrian.futbolappplayers.data.DataSource
import com.softwareofadrian.futbolappplayers.data.model.Player
import com.softwareofadrian.futbolappplayers.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {
    override suspend fun getPlayersList(playerName: String): Resource<List<Player>> {
        return dataSource.getPlayerByName(playerName)
    }
}