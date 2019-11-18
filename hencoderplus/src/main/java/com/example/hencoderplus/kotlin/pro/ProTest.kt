package com.example.hencoderplus.kotlin.pro

fun main(){
    val data = Data("1","data")
    val dataCopy = data.copy()
    println(data)
    println(dataCopy)
    println(data == dataCopy)
    println(data === dataCopy)

    //解构对象，通过data class内部自动实现的component方法,按照声明顺序，code是component1(),data是component2()
    val(code,name) = data
    println("解构对象code:$code,name:$name")


}

fun whenTest(){
    val colorRes = when (2) {
        1 -> ""
        2 -> "ok"
        else -> ""
    }
}

fun forTest(){
    val list = arrayListOf(1,2,3,4)
    for (item in list) print(item)
    for (i in list.indices) {
        print(list[i])
    }
    for ((index, value) in list.withIndex()) {
        println("the element at $index is $value")
    }

    //repeat循环函数，0..99
    repeat(100) { println(it)}
}

fun lambdaTest(){
    val list = listOf(1,2,3,4)
    list.forEach { it + 1 }
}

fun companyObject(){
    val application = BaseApplication.currentApplication
    //无法赋值因为set 被private了
}