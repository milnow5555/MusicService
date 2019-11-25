package com.example.musicservice.mvpcontract

interface LoginContract {

    interface LoginView {
        fun showEmailError()
        fun showPasswordError()
        fun onLoginSuccess()
        fun delegateToRegistrationActivity()
    }
    interface LoginPresenter {
        fun onSignInButtonClicked(email:String, password:String)
        fun onSignUpButtonClicked()
        fun onLoginSuccess()
        fun initLogOut()
    }

}