package com.softwareofadrian.futbolappplayers.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softwareofadrian.futbolappplayers.R
import com.softwareofadrian.futbolappplayers.data.DataSource
import com.softwareofadrian.futbolappplayers.data.model.Player
import com.softwareofadrian.futbolappplayers.domain.RepoImpl
import com.softwareofadrian.futbolappplayers.ui.adapter.PlayerAdapter
import com.softwareofadrian.futbolappplayers.viewmodel.MainViewModel
import com.softwareofadrian.futbolappplayers.viewmodel.VMFactory
import com.softwareofadrian.futbolappplayers.vo.Resource

class MainFragment : Fragment(), PlayerAdapter.OnPlayerClickListener {

    var recyclerViewPlayers: RecyclerView? = null
    var progressBar: RelativeLayout? = null
    var svPlayers: SearchView? = null

    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImpl(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupSearchView()
        setupObservers()

    }

    private fun setupObservers() {
        viewModel.fetchPlayersList.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    progressBar = view?.findViewById(R.id.progress_bar)
                    progressBar?.visibility = View.VISIBLE

                }
                is Resource.Success -> {
                    progressBar?.visibility = View.GONE
                    recyclerViewPlayers?.adapter =
                        PlayerAdapter(requireContext(), result.data, this)
                }
                is Resource.Failure -> {
                    progressBar?.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Ocurrio un error ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

    }


    private fun setupSearchView() {
        svPlayers = view?.findViewById(R.id.sv_players)
        svPlayers?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setPlayer(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }


    private fun setupRecyclerView() {
        recyclerViewPlayers = view?.findViewById(R.id.rv_players)
        recyclerViewPlayers?.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewPlayers?.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onPlayerClick(player: Player) {
        val bundle = Bundle()
        bundle.putParcelable("player", player)
        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
    }
}