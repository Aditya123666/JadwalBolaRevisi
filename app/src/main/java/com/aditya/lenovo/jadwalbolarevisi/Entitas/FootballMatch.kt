package com.aditya.lenovo.jadwalbolarevisi.Entitas

import com.google.gson.annotations.SerializedName

data class FootballMatch (
        @SerializedName("events") var events: List<Event>)