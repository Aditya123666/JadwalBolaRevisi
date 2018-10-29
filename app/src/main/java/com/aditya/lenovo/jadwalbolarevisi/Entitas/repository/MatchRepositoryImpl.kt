package com.aditya.lenovo.jadwalbolarevisi.Entitas.repository

import com.aditya.lenovo.jadwalbolarevisi.Entitas.FootballMatch
import com.aditya.lenovo.jadwalbolarevisi.Entitas.Teams
import com.aditya.lenovo.jadwalbolarevisi.api.FootballRest
import io.reactivex.Flowable

class MatchRepositoryImpl(private val footballRest: FootballRest) : MatchRepository {

    override fun getEventById(id: String): Flowable<FootballMatch> = footballRest.getEventById(id)

    override fun getUpcomingMatch(id: String): Flowable<FootballMatch> = footballRest.getUpcomingMatch(id)

    override fun getFootballMatch(id: String): Flowable<FootballMatch> = footballRest.getLastmatch(id)

    override fun getTeams(id: String): Flowable<Teams> = footballRest.getTeam(id)
}