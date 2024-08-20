package kr.co.ipdisk.quiz.database

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.co.ipdisk.quiz.database.Result

@Database(entities = [Result::class], version = 1)
abstract class ResultDatabase : RoomDatabase() {
    abstract fun resultDao() : ResultDao
}