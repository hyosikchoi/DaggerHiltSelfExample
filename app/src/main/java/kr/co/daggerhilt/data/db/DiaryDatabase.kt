package kr.co.daggerhilt.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import kr.co.daggerhilt.data.entity.Diary

@Database(entities = [Diary::class] , version = 1 , exportSchema = true)
abstract class DiaryDatabase : RoomDatabase() {

    abstract val diaryDao : DiaryDao
    
}