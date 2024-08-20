package kr.co.ipdisk.quiz.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")
data class Result(
    var name : String,
    var score : Int,
    var correctAnswer : Int,
    var uncorrctAnswer : Int,
    var totalQuestion : Int,
    var date : String
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0;
}
