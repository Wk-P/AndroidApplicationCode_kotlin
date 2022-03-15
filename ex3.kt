package com.example.myapplication

fun Year(y:Int):Int{
    return if (y % 400 == 0) {
        0
    } else {
        if (y % 4 == 0 && y % 100 != 0) {
            0
        } else {
            1
        }
    }
}

fun printer(number: Int){
    if(number == 0)
        println("윤년이 맞습니다.")
    else if(number == 1)
        println("윤년 아닙니다.")
}

fun main(){
    println("2000년은 윤년 일까?")
    printer(Year(2000))

    println("1900년은 윤년 일까?")
    printer(Year(1900))

    println("2002년은 윤년 일까?")
    printer(Year(2002))

    println("2013년은 윤년 일까?")
    printer(Year(2013))
}
