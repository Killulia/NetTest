package com.example.developers.jetpack.livedateAviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {
    var currentName: MutableLiveData<Int>? = null
        get() {
            if (field == null) {
                field = MutableLiveData(0)
            }
            return field
        }
        private set

    fun addNum( n:Int){
        currentName?.value = currentName?.value?.plus(n)
    }
}