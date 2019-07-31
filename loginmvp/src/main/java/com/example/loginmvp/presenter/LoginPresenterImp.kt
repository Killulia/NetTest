package com.example.loginmvp.presenter

import com.example.loginmvp.model.LoginModelImp
import com.example.loginmvp.model.User
import com.example.loginmvp.view.LoginView

class LoginPresenterImp(private val loginView: LoginView) : LoginPresenter{


    private val loginModel: LoginModelImp = LoginModelImp(this)


    override fun loginSuccess() {
        loginView.loginSuccess()
    }

    override fun loginFailure() {
        loginView.loginFailure()
    }

    override fun login(user: User) {
        loginModel.login(user)
    }


}