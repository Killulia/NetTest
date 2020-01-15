package com.example.developers.jetpack.livedateAviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.developers.R

class TestActivity : AppCompatActivity() {

    private lateinit var tvNum:TextView
    private lateinit var btAdd:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        initView()
    }

    private fun initView() {
        tvNum = findViewById(R.id.tvNum)
        btAdd = findViewById(R.id.btAdd)
        btAdd.setOnClickListener {
        }

    }
}
