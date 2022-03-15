package com.example.myapplication
import java.util.*

fun main() {
    var num = 0
    var pairList: MutableList<Int> = mutableListOf()
    var sc: Scanner = Scanner(System.`in`)

    num = sc.nextLine().toInt()
    for (i : Int in 0..num - 1 step (1)) {
        var temp = sc.nextLine().toInt()
        pairList.add(temp)
    }

    for (i : Int in 0..num - 1 step (1)){
        print("Pairs for ${pairList[i]} : ")

        for(j:Int in 1..pairList[i] step(1)){
            if(j >= pairList[i] - j)
                break
            else
                print("($j ${pairList[i] - j})")
            if(j + 1 >= pairList[i] - (j + 1)){

            }else
                print(",")
        }

    }
    println(" ")
}
