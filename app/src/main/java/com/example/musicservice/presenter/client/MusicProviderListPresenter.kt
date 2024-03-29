package com.example.musicservice.presenter.client

import com.example.musicservice.firebase.auth.FirebaseAuthManager
import com.example.musicservice.firebase.dao.client.ClientDao
import com.example.musicservice.firebase.dao.musicprovider.MusicProviderDao
import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import com.example.musicservice.model.MusicProvider
import com.example.musicservice.mvpcontract.client.MusicProviderListContract
import com.example.musicservice.presenter.BasePresenter
import java.util.LinkedHashMap
import javax.inject.Inject

class MusicProviderListPresenter @Inject constructor(private val auth : FirebaseAuthManager, private val musicProviderDao: MusicProviderDao)
    : BasePresenter<MusicProviderListContract.MusicProviderListView>, MusicProviderListContract.MusicProviderListPresenter {

    private lateinit var view : MusicProviderListContract.MusicProviderListView

    override fun setView(view: MusicProviderListContract.MusicProviderListView) {
        this.view = view
    }

    override fun obtainAllMusicProviders(name: Boolean, rating: Boolean, city: Boolean, active: Boolean) {
        var viewInvoker : (listOfMusicProviders:MutableList<MusicProvider?>) -> Unit = {
            val sortedList = sortThisList(it, name, rating, city, active)
            view.initializeRecyclerView(sortedList)
        }
        var progressBarInvoker : () -> Unit = {
            view.progressBarReaction()
        }
        musicProviderDao.getAllMusicProv(viewInvoker = viewInvoker, progressBarInvoker = progressBarInvoker)
    }

    override fun getUsername(): String = auth.getUserName()

    private fun sortThisList(listOfMusicProviders : MutableList<MusicProvider?>, name:Boolean, rating: Boolean, city: Boolean, active: Boolean) : MutableList<MusicProvider?> {

        if(active) {
            println(" --------------------------------------------------------------FILTERED")
            val list = listOfMusicProviders.filter { ac -> ac!!.active }
            val toMutableList = list.toMutableList()
            sortFiltered(toMutableList, name, rating, city)
            toMutableList.forEach{
                println("FILTERD  ${toMutableList}" )
            }
            return toMutableList
        }else {
            sortFiltered(listOfMusicProviders, name, rating, city)
            return listOfMusicProviders
        }

    }

    private fun sortFiltered(listOfMusicProviders : MutableList<MusicProvider?>, name:Boolean, rating: Boolean, city: Boolean) {
        var tempList : MutableList<MusicProvider?>
        if(name){
            println(" --------------------------------------------------------------SORTED BY NAME")
            listOfMusicProviders.sortBy { it?.name }
        }
        if (rating) {
            println(" --------------------------------------------------------------SORTED BY RATING")
            listOfMusicProviders.sortByDescending{ it?.rating }
        }
        if (city) {
            println(" --------------------------------------------------------------SORTED BY CITY")
            listOfMusicProviders.sortBy { it?.city }
        }
    }
}
