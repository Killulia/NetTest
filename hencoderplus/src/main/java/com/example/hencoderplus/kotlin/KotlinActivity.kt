package com.example.hencoderplus.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.hencoderplus.R

class KotlinActivity : AppCompatActivity() , View.OnClickListener {


    private val username:String = "username"
    private val password:String = "password"
    private lateinit var etName: EditText
    private lateinit var etPassword:EditText
    private lateinit var btLogin: Button
    private lateinit var cvTest:CodeView
    var test: String = ""
    lateinit var semi:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        etName = findViewById(R.id.et_name)
        etPassword = findViewById(R.id.et_password)
        btLogin = findViewById(R.id.bt_login)
        cvTest = findViewById(R.id.cv_msg)
        etName.setText("tmac")

        btLogin.setOnClickListener(this)
        cvTest.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        if (v is Button){
            login()
        }else if (v is CodeView){

        }
    }

    private fun login() {

    }

}
