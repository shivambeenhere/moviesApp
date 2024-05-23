package com.example.movieapp

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.movieapp.paging.MoviePagingSource
import com.example.movieapp.retrofit.MoviesApi
import javax.inject.Inject

class MovieRepository @Inject constructor(val moviesApi: MoviesApi) {

    fun getMovieList(searchString: String) = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 100),
        pagingSourceFactory = { MoviePagingSource(moviesApi, "6ed525f4", searchString) }
    ).liveData

}