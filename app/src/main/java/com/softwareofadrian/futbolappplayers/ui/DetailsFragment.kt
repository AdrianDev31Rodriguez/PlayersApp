package com.softwareofadrian.futbolappplayers.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.softwareofadrian.futbolappplayers.R
import com.softwareofadrian.futbolappplayers.data.model.Player


class DetailsFragment : Fragment() {

    private lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let { bundle ->
            player = bundle.getParcelable("player")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var ivDetailsPlayer: ImageView? = null
        var tvNamePlayerDetails: TextView? = null
        var tvDescriptionDetails: TextView? = null

        ivDetailsPlayer = view.findViewById(R.id.iv_player_details)
        tvNamePlayerDetails = view.findViewById(R.id.tv_player_name_details)
        tvDescriptionDetails = view.findViewById(R.id.tv_description_details)

        Glide.with(requireContext()).load(player.image).centerCrop().into(ivDetailsPlayer)
        tvNamePlayerDetails.text = player.namePlayer
        tvDescriptionDetails.text = player.description

    }

}