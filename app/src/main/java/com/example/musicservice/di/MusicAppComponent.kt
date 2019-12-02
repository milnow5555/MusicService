package com.example.musicservice.di

import com.example.musicservice.di.modules.AppModule
import com.example.musicservice.di.modules.FirebaseModule
import com.example.musicservice.di.modules.PresenterModule
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.firebase.dao.event.EventDao
import com.example.musicservice.firebase.dao.musicprovider.MusicProviderDao
import com.example.musicservice.presenter.LoginPresenter
import com.example.musicservice.presenter.RegisterPresenter
import com.example.musicservice.presenter.client.*
import dagger.Component
import javax.inject.Singleton

//TODO music provider activity - invitations inside profile
@Singleton
@Component(modules = [AppModule::class, PresenterModule::class])
interface MusicAppComponent {
    fun registerPresenter(): RegisterPresenter
    fun loginPresenter(): LoginPresenter
    fun clientDetailsFormPresenter() : ClientDetailsFormPresenter
    fun clientMainMenuPresenter() : ClientMainMenuPresenter
    fun clientPersonalProfilePresenter() : ClientPersonalProfilePresenter
    fun clientPersonalEventListPresenter() : ClientPersonalEventListPresenter
    fun clientAddEventPresenter() : ClientAddEventPresenter
    fun clientPersonalEventDetailsPresenter() : ClientPersonalEventDetailsPresenter
    fun clientPersonalProfileEditPresenter() : ClientPersonalProfileEditPresenter
    fun clientEventListPresenter() : ClientEventListPresenter
    fun musicProviderListPresenter(): MusicProviderListPresenter
    fun mpProfilePresenter() : ClientMpProfilePresenter

    fun clientDao() : ClientDao
    fun musicProviderDao() : MusicProviderDao
    fun eventDao() : EventDao


}