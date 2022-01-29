package com.softwareofadrian.futbolappplayers.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softwareofadrian.futbolappplayers.R
import com.softwareofadrian.futbolappplayers.base.BaseViewHolder
import com.softwareofadrian.futbolappplayers.data.model.Player

class PlayerAdapter(
    private val context: Context, private val playersList: List<Player>,
    private val itemClickListener: OnPlayerClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {


    interface OnPlayerClickListener {
        fun onPlayerClick(player: Player)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return PlayerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.players_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is PlayerViewHolder -> holder.bind(playersList[position], position)

        }
    }

    override fun getItemCount(): Int {
        return playersList.size
    }

    inner class PlayerViewHolder(itemView: View) : BaseViewHolder<Player>(itemView) {
        override fun bind(item: Player, position: Int) {

            var ivPlayer: ImageView? = null
            var tvNamePlayer: TextView? = null
            var tvDescription: TextView? = null
            ivPlayer = itemView.findViewById(R.id.iv_player)
            tvNamePlayer = itemView.findViewById(R.id.tv_player_name)
            tvDescription = itemView.findViewById(R.id.tv_description)

            Glide.with(context).load(item.image).centerCrop().into(ivPlayer)
            tvNamePlayer.text = item.namePlayer
            tvDescription.text = item.description
            itemView.setOnClickListener { itemClickListener.onPlayerClick(item) }

        }
    }
}
