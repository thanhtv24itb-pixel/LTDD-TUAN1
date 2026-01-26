package com.example.ok

// Bai3.kt
fun main() {
    val numbers = listOf(1, 4, 7, 10, 13, 20)

    println("Danh sach ban dau:")
    println(numbers)

    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("So chan:")
    println(evenNumbers)

    val squared = numbers.map { it * it }
    println("Binh phuong:")
    println(squared)

    val peopleAge = mutableMapOf(
        "An" to 20,
        "Binh" to 22,
        "Chi" to 19
    )

    println("Danh sach tuoi:")
    peopleAge.forEach { (name, age) ->
        println("$name : $age")
    }
}
