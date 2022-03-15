package com.example.myapplication
import java.util.*

fun menuPrint() {
    println("----선택하세요----")
    println("|(I)계좌번호\t\t|")
    println("|(D)입금\t\t\t|")
    println("|(W)출금\t\t\t|")
    println("|(E)종료\t\t\t|")
    println("----------------")
}

class MyAccount constructor() {
    fun Deposit() {
        var dep : Int
        println("입금하실 금액을 말하세요.")
        dep = readLine().toString().toInt()
        remaining += dep
        println("${dep} 원을 입금히였다.진액: ${remaining}")
        if (dep == 0) {
            println("신용등급이: ${level.toString()} -> ${level.toString()}")
            return
        }
        if (remaining >= 0) {
            println("신용등급이: ${level.toString()} -> ${accountlevels[level.ordinal - 1].toString()}로 한단계 상승합니다.")
            upGrade()
        }
        if (remaining >= 0 && level == levels.E) {
            frozen = false
        }
    }
    fun Withdraw() {
        var with : Int
        if (remaining < 0 && level == levels.F) {
            frozen = true
            frozenStatus()
        } else {
            println("출금하실 금액을 말하세요.")
            with = readLine().toString().toInt()
            remaining -= with
            if (with == 0) {
                println("${with} 원을 출급히였다.진액: ${remaining}.")
                println("신용등급이: ${level.toString()} -> ${level.toString()}")
                return
            }
            if (remaining >= -1000 && remaining < 0) {
                println("${with} 원을 출급히였다.진액: ${remaining}.")
                println("신용등급이: ${level.toString()} -> ${accountlevels[level.ordinal + 1].toString()}로 한단계 상승합니다.")
                downGrade()
                frozen = true
                frozenStatus()
            } else if (remaining < -1000) {
                remaining += with
                println("동결된 계좌에서 출금하실 수 없습니다.")
            } else {
                println("${with} 원을 출급히였다.진액: ${remaining}.")
            }
        }
    }

    fun downGrade() {
        level = accountlevels[level.ordinal + 1]
    }

    fun upGrade() {
        level = accountlevels[level.ordinal - 1]
    }

    fun Information() {
        println("계좌정보는 다음과 같습니다")
        println("|이름:     ${name}  |")
        println("|계좌잔액:  ${remaining}    |")
        println("|신용등급:  ${level.toString()}    |")
        println("----------------------")
    }

    fun frozenStatus() {
        if (frozen) {
            println("계좌가 동결됩니다")
        }
    }

    var frozen: Boolean = false
    var name: String = "Kim"
    var remaining: Int = 0
    var accountlevels: Array<levels> = levels.values()
    var level: levels = levels.C
    enum class levels {
        A, B, C, D, E, F
    }
}

fun main() {
    var input: String
    var scanner: Scanner = Scanner(System.`in`)
    var myaccount: MyAccount = MyAccount()
    while (true) {
        menuPrint()
        input = scanner.next().toString()
        when (input) {
            "I" -> myaccount.Information()
            "D" -> myaccount.Deposit()
            "W" -> myaccount.Withdraw()
            "E" -> break
        }
    }
}
