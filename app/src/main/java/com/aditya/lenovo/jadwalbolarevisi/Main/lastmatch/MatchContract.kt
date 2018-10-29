package com.aditya.lenovo.jadwalbolarevisi.Main.lastmatch

import com.aditya.lenovo.jadwalbolarevisi.Entitas.Event

interface MatchContract {
    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<Event>)
    }

    interface Presenter{
        fun getFootballMatchData()

    }
}