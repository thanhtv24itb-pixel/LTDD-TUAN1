// Bai1.kt
package com.example.ok
import kotlin.random.Random

class Dice(val numSides: Int) {
    fun roll(): Int {
        return Random.nextInt(1, numSides + 1)
    }
}

fun printLuckyMessage(roll: Int, luckyNumber: Int) {
    when (roll) {
        luckyNumber -> println("🎉 Trung so may man: $roll")
        1 -> println("Xui roi, ra so 1")
        6 -> println("Ra so 6, cung on đo")
        else -> println("Ra so $roll, thu lai nha")
    }
}

fun main() {
    val name = "Thanh"
    val luckyNumber = 4

    println("Xin chao $name")
    println("So may man: $luckyNumber")

    val dice = Dice(6)

    repeat(3) {
        val result = dice.roll()
        print("Lan ${it + 1}: ")
        printLuckyMessage(result, luckyNumber)
    }
}
