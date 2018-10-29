package com.aditya.lenovo.jadwalbolarevisi.Main.detail

import com.aditya.lenovo.jadwalbolarevisi.Entitas.Team
import com.aditya.lenovo.jadwalbolarevisi.Entitas.db.FavoriteMatch

interface DetailContract {

    interface View{
        fun displayTeamBadgeHome(team: Team)
        fun displayTeamBadgeAway(team: Team)
        fun setFavoriteState(favList:List<FavoriteMatch>)
    }

    interface Presenter{
        fun getTeamsBadgeAway(id:String)
        fun getTeamsBadgeHome(id:String)
        fun deleteMatch(id:String)
        fun checkMatch(id:String)
        fun insertMatch(eventId: String, homeId: String, awayId: String
        )
    }
}