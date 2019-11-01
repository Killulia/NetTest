package com.example.hencoderplus.kotlin

import okhttp3.Call
import okhttp3.Callback
import java.io.IOException

interface EntityCallback<T>{
    fun onSuccess(t:T)
    fun onFailure(message:String?)
}