package com.aditya.lenovo.jadwalbolarevisi.Main.PertandinganFav

import com.aditya.lenovo.jadwalbolarevisi.Entitas.Event

interface FavoriteMatchContract {
    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<Event>)
        fun hideSwipeRefresh()
    }

    interface Presenter{
        fun getFootballMatchData()

    }
}