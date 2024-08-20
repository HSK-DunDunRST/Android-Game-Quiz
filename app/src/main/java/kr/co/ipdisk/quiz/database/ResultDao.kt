package kr.co.ipdisk.quiz.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kr.co.ipdisk.quiz.database.Result

@Dao
interface ResultDao {
    @Insert
    suspend fun insertResult(result: Result)

    @Query("SELECT * FROM result_table ORDER BY date DESC")
    suspend fun getAllResults(): List<Result>
}