package com.aditya.lenovo.jadwalbolarevisi.Entitas.repository

import com.aditya.lenovo.jadwalbolarevisi.Entitas.FootballMatch
import com.aditya.lenovo.jadwalbolarevisi.Entitas.Teams
import io.reactivex.Flowable

interface MatchRepository {

    fun getFootballMatch(id : String) : Flowable<FootballMatch>

    fun getTeams(id : String = "0") : Flowable<Teams>

    fun getUpcomingMatch(id : String) : Flowable<FootballMatch>

    fun getEventById(id: String) : Flowable<FootballMatch>
}