package com.example.musicservice.model

data class Client(var id : String = "",
                  val name : String = "",
                  val surname : String = "",
                  val company : String = "",
                  val description : String = "",
                  val phone : String = "",
                  var email : String = "",
                  var username : String = "",
                  val clientEvents : List<Event> = listOf())

