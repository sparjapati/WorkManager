package com.sparjapati.workManager

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideNetworkApi(): NetworkApi {
        return Retrofit.Builder().baseUrl(NetworkApi.BASE_URl)
            .addConverterFactory(GsonConverterFactory.create()).build().create()
    }
}
