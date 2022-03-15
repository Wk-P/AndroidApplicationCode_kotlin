package com.example.myapplication

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()

    var T = IntArray(N + 10)
    var P = IntArray(N + 10)
    var dp = IntArray(N + 10)

    var max = 0

    for(i in 1..N){
        val st = StringTokenizer(readLine())

        T[i] = st.nextToken().toInt()
        P[i] = st.nextToken().toInt()
    }

    for(i in 1..N+1){
        dp[i] = Math.max(dp[i],max)
        max = Math.max(max,dp[i])
        dp[T[i]+i] = Math.max(dp[T[i]+i],P[i]+dp[i])
    }

    println(max)

    close()
}