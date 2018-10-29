package com.aditya.lenovo.jadwalbolarevisi.Entitas.repository

import com.aditya.lenovo.jadwalbolarevisi.Entitas.db.FavoriteMatch

interface LocalRepository {

    fun getMatchFromDb() : List<FavoriteMatch>

    fun insertData(eventId: String, homeId: String, awayId: String)

    fun deleteData(eventId: String)

    fun checkFavorite(eventId: String) : List<FavoriteMatch>
}