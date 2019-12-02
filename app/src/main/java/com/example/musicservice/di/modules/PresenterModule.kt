package com.example.musicservice.di.modules

import com.example.musicservice.mvpcontract.LoginContract
import com.example.musicservice.mvpcontract.RegisterContract
import com.example.musicservice.mvpcontract.client.*
import com.example.musicservice.presenter.LoginPresenter
import com.example.musicservice.presenter.RegisterPresenter
import com.example.musicservice.presenter.client.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Singleton
@Module(includes = [InteractionModule::class])
abstract class PresenterModule {

    @Binds
    abstract fun registrationPresenter(registerPresenter: RegisterPresenter) : RegisterContract.RegisterPresenter
    @Binds
    abstract fun loginPresenter(loginPresenter: LoginPresenter) : LoginContract.LoginPresenter
    @Binds
    abstract fun clienDetailsFormPresenter(clientDetailsFormPresenter: ClientDetailsFormPresenter) : ClientDetailsFormContract.ClientDetailsFormPresenter
    @Binds
    abstract fun clientMainMenuPresenter(clientMainMenuPresenter: ClientMainMenuPresenter) : ClientMainMenuContract.ClientMainMenuPresenter
    @Binds
    abstract fun clientPersonalProfilePresenter(clientPersonalProfilePresenter : ClientPersonalProfilePresenter) : ClientPersonalProfileContract.ClientPersonalProfilePresenter
    @Binds
    abstract fun clientAddEventPresenter(clientAddEventPresenter: ClientAddEventPresenter) : ClientAddEventContract.ClientAddEventPresenter
    @Binds
    abstract fun clientEventDetailsPresenter(clientPersonaleEventDetailsPresenter : ClientPersonalEventDetailsPresenter ) : ClientPersonalEventDetailsContract.ClientPersonalEventDetailsPresenter
    @Binds
    abstract fun clientPersonalProfileEditPresenter(clientPersonalProfileEditPresenter : ClientPersonalProfileEditPresenter) : ClientPersonalProfileEditContract.ClientPersonalProfileEditPresenter
    @Binds
    abstract fun clientEventListPresenter(clientEventListPresenter : ClientEventListPresenter) : ClientEventListContract.ClientEventListPresenter
    @Binds
    abstract fun musicProviderListPresenter(mpListPres : MusicProviderListPresenter) : MusicProviderListContract.MusicProviderListPresenter
    @Binds
    abstract fun mpProfilePresenter(mpProfile : ClientMpProfilePresenter) : ClientMpProfileContract.ClientMpProfilePresenter
}
