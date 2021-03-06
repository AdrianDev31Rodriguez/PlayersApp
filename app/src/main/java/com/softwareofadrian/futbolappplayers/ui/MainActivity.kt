package com.softwareofadrian.futbolappplayers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.softwareofadrian.futbolappplayers.R

class MainActivity : AppCompatActivity() {

    private lateinit var navControlador: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navControlador = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this, navControlador)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navControlador.navigateUp()
    }

}