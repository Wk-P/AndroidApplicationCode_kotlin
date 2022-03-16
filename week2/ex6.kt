package com.example.myapplication

class Calculator constructor() {
    var results: Array<Double> = arrayOf()
    fun varChange(number: Any): Double{
        return when (number) {
            is Int -> {
                number.toDouble()
            }
            is Double -> {
                number
            }
            else -> {
                Double.NaN
            }
        }
    }
    fun sum(number1: Double, number2: Double): Double{
        return number1 + number2
    }
    fun subtract(number1: Double, number2: Double): Double{
        return number1 - number2
    }
    fun multiple(number1: Double, number2: Double): Double{
        return number1 * number2
    }
    fun division(number1: Double, number2: Double): Double{
        if (number2 == 0.0) {
            return Double.NaN
        } else {
            return number1 / number2
        }
    }
    fun cal(num1: Any, num2: Any, type: String){
        var number1: Double = varChange(num1)
        var number2: Double = varChange(num2)
        when (type) {
            "add" -> {
                results = results.plus(sum(number1, number2))
            }
            "subtract" -> {
                results = results.plus(subtract(number1, number2))
            }
            "multiple" -> {
                results = results.plus(multiple(number1, number2))
            }
            "division" -> {
                if (division(number1, number2).isNaN()) {
                    println("ERROR : number can not be divided with zero.")
                } else {
                    results = results.plus(division(number1, number2))
                }
            }
            else -> {
                println("ERROR : input wrong.")
            }
        }
    }
    fun load() {
        for (result in results) {
            println("${result}")
        }
    }
    fun print_calculated_number() {
        if (!results.isEmpty()) {
            println(results[results.size-1])
        }
    }
}

fun main() {
    var calculator = Calculator()
    calculator.cal(1.0, 2.0, "add")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "subtract")
    calculator.print_calculated_number()
    calculator.cal(1.0, 0.0, "division")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "division")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "multiple")
    calculator.print_calculated_number()
    println("-------------")
    calculator.load()
}
