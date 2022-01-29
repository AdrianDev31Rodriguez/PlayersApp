package com.softwareofadrian.futbolappplayers.viewmodel

import androidx.lifecycle.*
import com.softwareofadrian.futbolappplayers.domain.Repo
import com.softwareofadrian.futbolappplayers.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo: Repo): ViewModel() {

    private val playersData = MutableLiveData<String>()

    fun setPlayer(playerName: String) {
        playersData.value = playerName
    }

    init {
        setPlayer("Danny")
    }


    val fetchPlayersList = playersData.distinctUntilChanged().switchMap { namePlayer ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())

            try {
                emit(repo.getPlayersList(namePlayer))

            }catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }
}