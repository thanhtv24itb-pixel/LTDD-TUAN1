// Bai2.kt
package com.example.ok
abstract class Dwelling(val residents: Int) {
    abstract fun floorArea(): Double

    fun capacity(): Int {
        return residents
    }
}

class SquareCabin(residents: Int, val side: Double) : Dwelling(residents) {
    override fun floorArea(): Double {
        return side * side
    }
}

class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override fun floorArea(): Double {
        return Math.PI * radius * radius
    }
}

fun main() {
    val cabin = SquareCabin(6, 5.0)
    val hut = RoundHut(3, 4.0)

    println("Square Cabin area: ${cabin.floorArea()}")
    println("Round Hut area: ${hut.floorArea()}")
}
