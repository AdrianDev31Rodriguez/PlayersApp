package com.softwareofadrian.futbolappplayers.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    @SerializedName("strThumb")
    val image: String = "",
    @SerializedName("strPlayer")
    val namePlayer: String = "",
    @SerializedName("strDescriptionEN")
    val description: String = ""
) : Parcelable

//lista del objeto entero de la api que tiene de nombre player
data class PlayerList(
    @SerializedName("player")
    val playerList: List<Player>
)
