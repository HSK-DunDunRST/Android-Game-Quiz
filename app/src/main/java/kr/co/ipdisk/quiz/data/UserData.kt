package kr.co.ipdisk.quiz.data

// Data.kt
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val userName: String,
    var correctAnswer : Int,
    var score: Int
) : Parcelable
