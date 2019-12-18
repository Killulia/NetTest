package com.example.kotlin.kaixue.p3

import com.example.kotlin.kaixue.p1.User
import java.lang.IllegalArgumentException


fun main() {
    val pA = PartA(1, "first")
    pA.id = 2
    val pA2 = PartA()
    pA2.display()
    sayHi(age = 21, isStudent = false)
    login("殇不患", "123", "用户名和密码不能为空")

//    login("", "", "用户名和密码不能为空")
}

/*
默认参数
 */
fun sayHi(name: String = "world", age: Int, isStudent: Boolean = true, isFat: Boolean = true, isTall: Boolean = true) {
    println("name:$name,age:$age,isStudent:$isStudent,isFat:$isFat,isTall:$isTall")
}

/*
嵌套函数
 */
fun login(user: String, password: String, illeaglStr: String) {

    fun validate(value: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(illeaglStr)
        }
    }

    validate(user)
    validate(password)

}

/*
原生字符串-最后输出的内容和""" """内的内容完全一致,$ 符号引用变量仍然生效
 */
fun rawString() {
    val string:String = """
        |Hi my name is
                |lalala.\n
            """.trimMargin()
    print(string)
}

/*
数组与集合
 */
fun arrayList(){
    val intArray = intArrayOf(1,2,3)
    //操作集合中元素
    intArray.forEach { i -> print(i) }
    val filterArray = intArray.filter { i -> i!=1 }
    filterArray.forEach { i -> print(i) }
    //操作集合中元素，并返回新集合
    val mapArray = intArray.map { i -> i + 1 }
    mapArray.forEach{i -> print(i)}
    //操作集合中元素并且每个元素生成一个集合，并返回总的集合
    val flatMapList = intArray.flatMap { i -> listOf("$i","flat") }
    flatMapList.forEach { i -> print(i) }
}

fun range(){
    val range = 0..5
    for (i in range){
        println("$i")
    }
}

/*
?:运算符
 */
fun validate(user: User) {
    val name = user.name ?: return // 👈 验证 user.id 是否为空，为空时 return
}

/*
等号用法 ==比较值 ===比较地址
 */
fun eqaulsTest(){
    val str1 = "123"
    val str2 = "123"
    println(str1 == str2) // 👈 内容相等，输出：true
    val str3= "字符串"
    val str4 = str3
    val str5 = str3
    print(str4 === str5) // 👈 引用地址相等，输出：true
}


/*
操作符
 */
fun whenTest(){
    val str:String? = "string"
    when{
        str?.length?:1 > 0 -> println("bingo")
    }
    when(str?.length){
        1,2 -> println("bingo")
        else -> println("error")
    }
}






/*
构造函数
 */
//如果没有被「可⻅性修饰符」「注解」标注，那么主构造函数的constructor 可以省略
class PartA (var id: Int, name: String) {

    init {
        println("id is ${this.id},name is $name")
    }

    constructor() : this(5, "8") {
        println("second")
    }

    fun display() {
        println("repeat id is ${this.id}")
    }

}