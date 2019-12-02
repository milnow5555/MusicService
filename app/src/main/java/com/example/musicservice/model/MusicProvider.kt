package com.example.musicservice.model

data class MusicProvider(var id : String? = "",
                         val name : String = "",
                         val active : Boolean = true,
                         val city : String = "",
                         val description : String = "",
                         val rating : Double = 0.0,
                         val musicProvidersApproachingEvents : List<Event> = listOf(),
                         val musicProvidersInvitations : List<Event> = listOf(),
                         val musicProviderType : String = "",
                         val musicalPreferences: String  = "") {


    enum class MusicPoviderType {
        Orchestra, Band, BigBand, Musician, Composer, Producer, DJ
    }
    enum class MusicProviderMusicalPreferences {
        Jazz, Metal, Classical, HardRock, HipHop, Regge, Wedding, Party, Blues, Rock_and_roll, Country, Soul, Rap, Black_Metal, Death_Metal, Progressive_Rock
    }
}