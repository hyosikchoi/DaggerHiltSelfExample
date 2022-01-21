package kr.co.daggerhilt.remote

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import retrofit2.http.GET


interface ExternalApi {

    @GET("ping")
    suspend fun pingPong() : Response<String>
}