package kr.co.daggerhilt.data.db

import androidx.room.*
import kr.co.daggerhilt.data.entity.Diary

@Dao
interface DiaryDao {

    @Query("SELECT * FROM Diary")
    suspend fun getDiaryList() : List<Diary>

    @Query("SELECT * FROM Diary WHERE id = :id")
    suspend fun getDiary(id : Long) : Diary

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiary(diary: Diary)

    @Update
    suspend fun updateDiary(diary: Diary)

}