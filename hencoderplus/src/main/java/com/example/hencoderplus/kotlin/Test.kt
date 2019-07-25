package com.example.hencoderplus.kotlin


fun main(){
    var index:Int
    val b: Int? = 2
    var a: String = ""
    val aInt: Int? = a as? Int
    var user:User = User("king")

    println("user:${user.name}")
    println("user:${user.id?.plus(2)}")
    var user2:User = User(1,"alpha")
}


