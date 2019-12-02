package com.example.musicservice.ui.client.musicproviderlist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicservice.MusicApp
import com.example.musicservice.R
import com.example.musicservice.model.MusicProvider
import com.example.musicservice.presenter.client.MusicProviderListPresenter
import com.example.musicservice.mvpcontract.client.MusicProviderListContract
import com.example.musicservice.ui.client.ClientMainMenuActivity
import kotlinx.android.synthetic.main.activity_client_event_list.*
import kotlinx.android.synthetic.main.activity_client_music_providers_list.*

class MusicProviderListActivity : AppCompatActivity(), MusicProviderListContract.MusicProviderListView {

    private val presenter : MusicProviderListPresenter = MusicApp.component.musicProviderListPresenter()
    private val PREFS_FILENAME  : String =  "myprefs"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_music_providers_list)
        presenter.setView(this)

        val prefs = this.getSharedPreferences(PREFS_FILENAME, 0)
        val editor = prefs!!.edit()


        mplist_usernametext.text = presenter.getUsername()
        backimage.setOnClickListener{
            var intent = Intent(this, ClientMainMenuActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }


        val stringExtra = intent.getStringExtra("first_time")
        if(stringExtra == "first") {
            if(!prefs.contains("name_prev")) {
                println("NOT CONTAINS SHARED PREV -------------------")
                presenter.obtainAllMusicProviders(false,false,false,false)
            }
            else {
                println("CONTAINS SHARED PREV -------------------")
                presenter.obtainAllMusicProviders(prefs.getBoolean("name_prev", false),prefs.getBoolean("rating_prev", false)
                    ,prefs.getBoolean("city_prev", false),prefs.getBoolean("active_prev", false))
            }
        }
        else presenter.obtainAllMusicProviders(
            intent.getBooleanExtra("name", false),
            intent.getBooleanExtra("rating", false),
            intent.getBooleanExtra("city", false),
            intent.getBooleanExtra("active", false))

        button_confirm.setOnClickListener{
            var nameCheckBox : Boolean = false
            var ratingCheckBox : Boolean = false
            var cityCheckBox : Boolean = false
            var activeCheckBox : Boolean = false
            var firstTime : String = "nein"

            if(namecheckbox.isChecked) nameCheckBox = true
            if(ratingcheckbox.isChecked) ratingCheckBox = true
            if(citycheckbox.isChecked) cityCheckBox = true
            if(activecheckbox.isChecked) activeCheckBox = true


            editor.putBoolean("name_prev", nameCheckBox)
            editor.putBoolean("rating_prev", ratingCheckBox)
            editor.putBoolean("city_prev", cityCheckBox)
            editor.putBoolean("active_prev", activeCheckBox)
            //todo or commit
            editor.apply()

            var intent : Intent = Intent(this, MusicProviderListActivity::class.java)
            intent.putExtra("first_time", firstTime)
            intent.putExtra("name", nameCheckBox)
            intent.putExtra("rating", ratingCheckBox)
            intent.putExtra("city", cityCheckBox)
            intent.putExtra("active", activeCheckBox)
            startActivity(intent)
        }
    }

        override fun progressBarReaction() {
            if(music_prov_progrssbar.visibility == ProgressBar.GONE) music_prov_progrssbar.visibility = ProgressBar.VISIBLE
            else music_prov_progrssbar.visibility = ProgressBar.GONE
        }


    override fun initializeRecyclerView(musicProviderList: MutableList<MusicProvider?>) {
        var mucic : MusicProviderListAdapter =
            MusicProviderListAdapter(musicProviderList, this)

        musicProviderList.forEach{
            println("ELEMENT ---------- ${it}")
        }

        recyclerview_musicprov.adapter = mucic
        recyclerview_musicprov.layoutManager = LinearLayoutManager(this)
    }
}