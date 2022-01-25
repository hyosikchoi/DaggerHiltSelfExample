package kr.co.daggerhilt.di

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.co.daggerhilt.constants.Constant
import kr.co.daggerhilt.data.db.DiaryDao
import kr.co.daggerhilt.data.db.DiaryDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule  {

    @Provides
    @Singleton
    fun provideDiaryDatabase(
        @ApplicationContext appContext : Context
    ) : DiaryDatabase
    = Room.databaseBuilder(
        appContext,
        DiaryDatabase::class.java,
        Constant.DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideDiaryDao(
        diaryDatabase: DiaryDatabase
    ) : DiaryDao
    = diaryDatabase.diaryDao

}
