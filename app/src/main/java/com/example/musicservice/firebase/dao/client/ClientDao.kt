package com.example.musicservice.firebase.dao.client

import com.example.musicservice.firebase.dao.FirebaseDao
import com.example.musicservice.model.Client
import com.google.firebase.database.DatabaseReference

interface ClientDao : FirebaseDao<Client> {
    fun findByClientCompany(company : String) : Client
    fun findByClientType(type : String) : Client
    fun updateClient(client : Client)
    fun getById(id:String?): DatabaseReference
}