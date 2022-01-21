package kr.co.daggerhilt.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import kr.co.daggerhilt.remote.ExternalApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object AppModule  {

    @Provides
    fun provideExternalApi() : ExternalApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .baseUrl("https://ext.meetcha.co.kr")
            .build()
            .create(ExternalApi::class.java)
    }

}
