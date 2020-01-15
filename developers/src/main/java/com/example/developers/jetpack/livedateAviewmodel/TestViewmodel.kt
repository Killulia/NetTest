package com.example.developers.jetpack.livedateAviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewmodel : ViewModel() {
    val num: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}


