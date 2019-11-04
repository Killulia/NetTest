package com.example.kotlin.apipdf

var a = "a"
val b = "${a.replace("a", "b")},old is $a"
fun main() {
   dataClass()
}

fun maxOf(a: Int, b: Int) = if (a > b) "big" else "small"

fun isClass(obj: Any): Int? {
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}

fun forIndex() {
    val list = listOf<String>("A", "B", "C")
    for (index in list.indices) {
        println("item at $index is ${list[index]}")
    }

}

fun whenTest(obj: Any): String =
        when (obj) {
            1       -> "one"
            "hello" -> "hello"
            else    -> "other"
        }

fun range(x:Int){
    //两边都是闭区间
    if (x !in 1..10){
        println("out of range")
    }
    //1-10区间迭代
    for (i in 1..10) {
        println("$i in range")
    }

    //1-10区间 5为步长迭代
    for (i in 1..10 step 5) {
        println("$i in range")
    }

    //检查是否包含某元素
    val str = "test"
    val list = listOf<String>("t","b")
    if ("t" in str && "t" in list){
        println("all in")
    }

}

fun dataClass(){
    val data = Data(1,"first")
    data.name = "two"
    println("id:${data.id},name:${data.name}")
}

data class Data(val id:Int,var name:String)

