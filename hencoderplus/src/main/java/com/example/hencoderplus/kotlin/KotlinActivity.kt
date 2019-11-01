package com.example.hencoderplus.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.hencoderplus.R

class KotlinActivity : AppCompatActivity(), View.OnClickListener {

    private val usernameKey = "usernameKey"
    private val passwordKey = "passwordKey"


    private lateinit var etName: EditText
    private lateinit var etPassword:EditText
    private lateinit var btLogin: Button
    private lateinit var cvTest: CodeView


    companion object{
        private const val TEST = "编译期常量测试"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        etName = findViewById(R.id.et_name)
        etPassword = findViewById(R.id.et_password)
        btLogin = findViewById(R.id.bt_login)
        cvTest = findViewById(R.id.cv_msg)
        btLogin.setOnClickListener(this)
        cvTest.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        if (v is Button){
            login()
        }else if (v is CodeView){
            v.updateCode()
            Utils.toast(TEST)
        }
    }

    private fun login() {
        startActivity(Intent(this,LessonActivity::class.java))
    }

}



