package com.aditya.lenovo.jadwalbolarevisi.Main.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.aditya.lenovo.jadwalbolarevisi.R

import com.aditya.lenovo.jadwalbolarevisi.Main.PertandinganFav.FavoriteMatchFragment
import com.aditya.lenovo.jadwalbolarevisi.Main.PertandinganTerakhir.LastMatchFragment
import com.aditya.lenovo.jadwalbolarevisi.Main.PertandinganSelanjutnya.UpcomingMatchFragment
import kotlinx.android.synthetic.main.home_activity.*

class MainActivity : AppCompatActivity(), MainContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.lastMatch -> {
                    loadLastMatch(savedInstanceState)
                }
                R.id.upMatch -> {
                    loadUpcomingMatch(savedInstanceState)
                }
                R.id.favMatch -> {
                    loadFavoritesMatch(savedInstanceState)
                }
            }
            true
        }

        bottom_navigation.selectedItemId = R.id.lastMatch
    }

    private fun loadLastMatch(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, LastMatchFragment(), LastMatchFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadUpcomingMatch(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, UpcomingMatchFragment(), UpcomingMatchFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadFavoritesMatch(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, FavoriteMatchFragment(), FavoriteMatchFragment::class.java.simpleName)
                    .commit()
        }
    }

}
