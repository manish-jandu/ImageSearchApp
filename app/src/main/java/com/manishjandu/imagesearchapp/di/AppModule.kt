package com.manishjandu.imagesearchapp.di

import com.manishjandu.imagesearchapp.api.UnsplashAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit =
        Retrofit.Builder()
            .baseUrl(UnsplashAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideUnsplashAPI(retrofit: Retrofit):UnsplashAPI=
        retrofit.create(UnsplashAPI::class.java)

}