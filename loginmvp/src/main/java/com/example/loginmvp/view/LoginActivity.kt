package com.example.loginmvp.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginmvp.R
import com.example.loginmvp.model.User
import com.example.loginmvp.presenter.LoginPresenterImp

class LoginActivity : AppCompatActivity(), LoginView, View.OnClickListener {

    private lateinit var etName: EditText
    private lateinit var etPassword: EditText
    private lateinit var btLogin: Button
    private lateinit var loginPresenterImp: LoginPresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginPresenterImp = LoginPresenterImp(this)
        initView()
    }


    private fun initView() {
        etName = findViewById(R.id.et_name)
        etPassword = findViewById(R.id.et_password)
        btLogin = findViewById(R.id.bt_login)
        btLogin.setOnClickListener(this)
    }

    private fun login() {
        val user1 = User()
        user1.name = "sdf"

        val user = User(etName.text.toString(), etPassword.text.toString())
        loginPresenterImp.login(user)
    }

    override fun loginSuccess() {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show()
    }

    override fun loginFailure() {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_login -> login()
        }
    }


}