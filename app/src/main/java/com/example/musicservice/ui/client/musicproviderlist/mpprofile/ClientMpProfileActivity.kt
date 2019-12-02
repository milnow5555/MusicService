package com.example.musicservice.ui.client.musicproviderlist.mpprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicservice.MusicApp
import com.example.musicservice.R
import com.example.musicservice.mvpcontract.client.ClientMpProfileContract
import com.example.musicservice.presenter.client.ClientMpProfilePresenter

class ClientMpProfileActivity : AppCompatActivity(), ClientMpProfileContract.ClientMpProfileView{

    private val presenter : ClientMpProfilePresenter = MusicApp.component.mpProfilePresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mp_profile)
        presenter.setView(this)
    }
}