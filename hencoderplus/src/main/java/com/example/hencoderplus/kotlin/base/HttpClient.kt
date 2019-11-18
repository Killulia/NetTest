package com.example.hencoderplus.kotlin.base

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

object HttpClient : OkHttpClient(){

    private val gson = Gson()

    fun <T> convert(json:String?,type: Type):Type{
        return gson.fromJson(json,type)
    }

    fun <T> get(path:String?,type: Type,entityCallback: EntityCallback<T>){
        val request:Request = Request.Builder()
                .url("https://hencoder.com/${path}")
                .build()
        val call:Call = this.newCall(request)

        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                when (response.code) {
                    in 200..299 -> {

                    }
                    in 400..499 -> {
                        entityCallback.onFailure("client fail")
                    }
                    in 500..599 -> {
                        entityCallback.onFailure("sever fail")
                    }
                    else -> {
                        entityCallback.onFailure("unknown")
                    }
                }
            }
        })
    }


}