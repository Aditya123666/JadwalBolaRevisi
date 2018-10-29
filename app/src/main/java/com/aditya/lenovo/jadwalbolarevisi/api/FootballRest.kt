package com.aditya.lenovo.jadwalbolarevisi.api

import com.aditya.lenovo.jadwalbolarevisi.Entitas.FootballMatch
import com.aditya.lenovo.jadwalbolarevisi.Entitas.Teams
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballRest {

    @GET("eventspastleague.php")
    fun getLastmatch(@Query("id") id:String) : Flowable<FootballMatch>

    @GET("eventsnextleague.php")
    fun getUpcomingMatch(@Query("id") id:String) : Flowable<FootballMatch>

    @GET("lookupteam.php")
    fun getTeam(@Query("id") id:String) : Flowable<Teams>

    @GET("lookupevent.php")
    fun getEventById(@Query("id") id:String) : Flowable<FootballMatch>
}