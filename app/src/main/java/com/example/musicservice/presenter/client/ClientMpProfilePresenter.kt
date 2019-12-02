package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.musicprovider.MusicProviderDao
import com.example.musicservice.mvpcontract.client.ClientMpProfileContract
import com.example.musicservice.presenter.BasePresenter
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class ClientMpProfilePresenter@Inject constructor(private val auth : FirebaseAuthManager, private val mpDao : MusicProviderDao) : BasePresenter<ClientMpProfileContract.ClientMpProfileView>, ClientMpProfileContract.ClientMpProfilePresenter {

    private lateinit var view : ClientMpProfileContract.ClientMpProfileView
    override fun setView(view: ClientMpProfileContract.ClientMpProfileView) {
        this.view = view
    }


}