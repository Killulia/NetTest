package com.example.kotlin.kaixue.p1

class User {
    var name = "vex"
    set(value) {
        field = value+"钩子"
    }
    get() {
        return field+"完成"
    }
}