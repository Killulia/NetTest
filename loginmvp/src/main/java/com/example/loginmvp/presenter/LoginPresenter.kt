package com.example.loginmvp.presenter

import com.example.loginmvp.model.User

interface LoginPresenter {
     fun loginSuccess()


     fun loginFailure()


     fun login(user: User)
}