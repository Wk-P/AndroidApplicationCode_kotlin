package com.example.applicationlab

import java.util.*

enum class Menu(var input: Int, var price: Int) {참깨라면(1, 1000), 햄버거(2, 1500), 콜라(3, 800), 핫바(4, 1200), 초코우유(5, 1500)}

fun getMenu() :Int? {
    println("========== MENU ==========")
    println("|(1) 참깨라면          -1,000원   |")
    println("|(2) 햄버거           -1,500원   |")
    println("|(3) 콜라            -  800원   |")
    println("|(4) 핫바            -1,200원   |")
    println("|(5) 초코우유          -1,500원   |")

    println("Choose menu:")
    val sc: Scanner = Scanner(System.`in`)
    val inputString = sc.nextLine()

    if (inputString == null) {
        println("아무것도 선택하지 않습니다.\n다시 선택해 주세요.")
        return null
    }

    try {
        val input = Integer.parseInt(inputString)
        if (input < 6 && input > 0) {
            println("${Menu.values()[input-1].name} 선택되었습니다.")
            return input
        } else {
            println("아무것도 선택하지 않습니다.\n다시 선택해 주세요.")
            return null
        }
    } catch (e: NumberFormatException) {
        println("아무것도 선택하지 않습니다.\n다시 선택해 주세요.")
        return null
    }
}

fun getCoin() :Int? {
    val sc: Scanner
    val coin: Int
    println("Insert coin")
    sc = Scanner(System.`in`)
    if (!sc.hasNextInt()) {
        println("돈을 넣지 않습니다.\n다시 돈을 넣어주세요.")
        return null
    } else {
        coin = sc.nextInt()
        println("${coin} 원을 넣었습니다.")
        return coin
    }
}

fun getPrice(input: Int):Int {
    return Menu.values()[input-1].price
}

fun getChange(coin: Int?, input: Int?) :Int?{
    if (input == null || coin == null) {
        return null
    }
    val change = coin - getPrice(input)
    if (change < 0) {
        return null
    } else {
        return change
    }
}

fun main() {
    var input: Int?
    var coin: Int?
    var change: Int?
    // getMenu()
    while (true) {
        input = getMenu()
        if (input != null) {
            break
        }
    }
    // getCoin()
    while (true) {
        coin = getCoin()
        if (coin != null) {
            break
        }
    }
    // getPrice() and getChange()
    change = getChange(coin, input)
    if (change == null) {
        println("현금 부족합니다.")
    } else {
        println("감사합니다. 잔돈반환:${change}")
    }
}