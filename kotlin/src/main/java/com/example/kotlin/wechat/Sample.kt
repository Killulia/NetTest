package com.example.kotlin.wechat

import com.example.kotlin.kaixue.p1.User

fun main(){
    println(helloWorld())
}

fun helloWorld() = """${'$'}1000"""

fun ifTest(){
    var a = 0
    var b = 2
    val c = if(a>b) 1 else 2

}

fun mapTest(){
    val books = listOf<User>(User("a"),User("b"),User("c"))
            .map (User::name)
}