package com.example.movieapp.di

import com.example.movieapp.retrofit.MoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl("http://www.omdbapi.com").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getMoviesApiService(retrofit : Retrofit) : MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

}