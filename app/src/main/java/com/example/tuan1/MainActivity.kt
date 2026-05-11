package com.example.tuan1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.tuan1.ui.theme.Tuan1Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// --- BÀI 2 & 4: ĐỊNH NGHĨA LỚP VÀ ENUM (Nằm ngoài class MainActivity) ---
abstract class Dwelling(val material: String) {
    abstract fun floorArea(): Double
}

class RoundHut(val residents: Int) : Dwelling("Gỗ") {
    override fun floorArea(): Double = 45.5
}

enum class Direction { NORTH, SOUTH, WEST, EAST }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Gọi hàm thực hiện bài tập
        chayBaiTap()

        setContent {
            Tuan1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Tuấn - Đã hoàn thành 4 bài",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun chayBaiTap() {
        Log.d("KET_QUA", "========== BẮT ĐẦU CHƯƠNG TRÌNH ==========")

        // --- BÀI 1: CƠ BẢN (Biến, String Template, If-Else) ---
        val studentName = "Thành Tuấn"
        var score = (1..10).random() // Số ngẫu nhiên
        Log.d("KET_QUA", "Bài 1: Chào $studentName. Điểm ngẫu nhiên: $score")

        // --- BÀI 2: OOP & DANH SÁCH ---
        val myHut = RoundHut(3)
        val projects = mutableListOf("AppNote", "MusicPlayer")
        projects.add("FirebaseProject")
        Log.d("KET_QUA", "Bài 2: Vật liệu nhà: ${myHut.material}. DS dự án: $projects")

        // --- BÀI 3: MAP, FILTER & NULL SAFETY (Phần bạn tìm đây!) ---
        val scoresMap = mutableMapOf("Kotlin" to 9, "Java" to 8, "C++" to 4)
        // Lọc các môn có điểm >= 5 (Lambda & Filter)
        val passedSubjects = scoresMap.filter { it.value >= 5 }

        // Null Safety (Toán tử Elvis)
        val bonusPoint: Int? = null
        val totalScore = (scoresMap["Kotlin"] ?: 0) + (bonusPoint ?: 0)

        Log.d("KET_QUA", "Bài 3 - Môn đã đạt: $passedSubjects")
        Log.d("KET_QUA", "Bài 3 - Tổng điểm Kotlin: $totalScore")

        // --- BÀI 4: COROUTINE, ENUM & TRY-CATCH ---
        val move = Direction.NORTH
        Log.d("KET_QUA", "Bài 4 - Hướng di chuyển: $move")

        // Sử dụng Coroutine (Xử lý bất đồng bộ)
        lifecycleScope.launch {
            try {
                Log.d("KET_QUA", "Bài 4 - Đang tải dữ liệu...")
                delay(2000) // Giả lập chờ 2 giây
                Log.d("KET_QUA", "Bài 4 - Tải dữ liệu thành công!")
            } catch (e: Exception) {
                Log.d("KET_QUA", "Bài 4 - Lỗi: ${e.message}")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!\nKiểm tra Logcat với tag KET_QUA nhé.", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tuan1Theme { Greeting("Android") }
}