package com.example.developers.jetpack.livedateAviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.developers.R

class TestActivity : AppCompatActivity() {

    private lateinit var tvNum:TextView
    private lateinit var btAdd:Button
    private lateinit var model: TestViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        model = ViewModelProviders.of(this).get(TestViewModel::class.java)
        val numObserver = Observer<Int> { newName ->
            tvNum.text = newName.toString()
        }
        model.currentName?.observe(this, numObserver)
        initView()
    }

    private fun initView() {
        tvNum = findViewById(R.id.tvNum)
        btAdd = findViewById(R.id.btAdd)
        btAdd.setOnClickListener {
            model.addNum(1)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ccg","destroy")
    }
}
