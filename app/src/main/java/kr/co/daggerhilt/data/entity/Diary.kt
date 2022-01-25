package kr.co.daggerhilt.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Diary(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val title : String,
    val description : String
)
