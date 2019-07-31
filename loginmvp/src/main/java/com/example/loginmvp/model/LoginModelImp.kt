package com.example.loginmvp.model

import com.example.loginmvp.presenter.LoginPresenter

class LoginModelImp(private val loginPresenter: LoginPresenter) : LoginModel{

    override fun login(user: User) {
        if ("123" == user.name && "123" == user.password) {
            loginPresenter.loginSuccess()
        } else {
            loginPresenter.loginFailure()
        }
    }

}