package com.example.applicationlab

import java.util.*

fun change(str: String) :String {
    var wrong_string = ""
    for (item in str) {
        if (!item.isLowerCase()) {
            wrong_string += item
        }
    }
    return if (wrong_string != "") {
        "error with = " + wrong_string
    } else {
        str.uppercase(Locale.getDefault())
    }
}

fun main() {
    var a = "abcd"
    println(change(a))

    var b = "EfgH"
    println(change(b))

    var c = "!@%$"
    println(change(c))
}
