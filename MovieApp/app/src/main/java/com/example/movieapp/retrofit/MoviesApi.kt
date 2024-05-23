package com.example.movieapp.retrofit

import com.example.movieapp.models.MovieDetail
import com.example.movieapp.models.movies
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    // http://www.omdbapi.com/?apikey={API_KEY}&s={SEARCH_STRING}&page={PAGE_NO}

    @GET("/")
    suspend fun getMoviesList(@Query("key") key : String, @Query("s") searchVal : String, @Query("page") pageNo : Int) : movies

    @GET("/")
    suspend fun getMovieDetail(@Query("i") imdbId : String, @Query("key") key : String) : MovieDetail
}