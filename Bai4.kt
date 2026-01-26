package com.example.ok

// Bai4.kt
import kotlinx.coroutines.*

suspend fun loadData(): String {
    delay(1000)
    return "Du lieu da load xong"
}

fun main() = runBlocking {
    println("Bat dau")
    val data = loadData()
    println(data)
    println("Ket thuc")
}
