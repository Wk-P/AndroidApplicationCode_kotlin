package com.example.week3application

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class xy(val x:Int, val y:Int)

val bufferedreader = BufferedReader(InputStreamReader(System.`in`))
val bufferedwriter = BufferedWriter(OutputStreamWriter(System.out))

val dx = mutableListOf<Int> (-1 , 1 , 0 , 0)
val dy = mutableListOf<Int> (0 , 0 , -1 , 1)

val input = readLine()!!
    .split(" ")
    .map{
        it.toInt()
    }
val x = input[0]
val y = input[1]

val graph = Array(x , {IntArray(y , {0})})
var copy_graph = Array(x , {IntArray(y , {0})})
var visit = Array(x , {BooleanArray(y , {false})})

var ans = Int.MIN_VALUE

fun main() = with(bufferedreader){
    for(i in 0 until x){
        var line = readLine()!!
            .split(" ")
            .map{
                it.toInt()
            }
        for(j in line.indices){
            graph[i][j] = line[j]
        }
    }
    wall(0)
    println(ans)
    bufferedwriter.flush()
    bufferedwriter.close()
}
fun bfs(){
    var q : Queue < Pair <Int,Int> > = LinkedList()

    for(i in 0 until x){
        for(j in 0 until y){
            if(copy_graph[i][j] == 2){
                q.add(Pair(i , j))
                visit[i][j] = true
            }
        }
    }

    while(!q.isEmpty()){
        var a = q.poll()
        for(i in 0 until 4){
            var dx = a.first + dx[i]
            var dy = a.second + dy[i]
            if(dx < 0 || dx >= x || dy < 0 || dy >= y || visit[dx][dy]){
                continue
            }
            if (copy_graph[dx][dy] != 0)
                continue
            copy_graph[dx][dy]=2
            visit[dx][dy] = true
            q.add(Pair(dx , dy))
        }
    }
    var cnt = 0

    for(i in 0 until x){
        for(j in 0 until y){
            if(copy_graph[i][j]==0){
                cnt++
            }
        }
    }
    if(cnt > ans){
        ans = cnt
    }
    q.clear()
}

fun wall(cnt : Int){
    if(cnt==3){
        for(i in 0 until x){
            for(j in 0 until y){
                visit[i][j] = false
                copy_graph[i][j] = graph[i][j]
            }
        }

        bfs()
        return
    }
    for(i in 0 until x){
        for(j in 0 until y){
            if(graph[i][j] == 0){
                graph[i][j] = 1
                wall(cnt + 1)
                graph[i][j] = 0
            }
        }
    }
}
