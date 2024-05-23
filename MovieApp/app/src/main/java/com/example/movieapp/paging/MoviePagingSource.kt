package com.example.movieapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movieapp.models.Search
import com.example.movieapp.models.movies
import com.example.movieapp.retrofit.MoviesApi

class MoviePagingSource(private val moviesApi: MoviesApi, private val key : String, private val searchString : String) : PagingSource<Int, Search>() {

    override fun getRefreshKey(state: PagingState<Int, Search>): Int? {
        if (state.anchorPosition != null) {
            val page = state.closestPageToPosition(state.anchorPosition!!)
            if (page?.prevKey != null) return page.prevKey!!.plus(1)
            else if (page?.nextKey != null) return page.nextKey!!.minus(1)
        }
        else return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Search> {
        return try {
            val pos = params.key ?: 1
            val response = moviesApi.getMoviesList(key, searchString, pos)

            LoadResult.Page(
                data = response.Search,
                prevKey = if (pos == 1) null else pos - 1,
                nextKey = if (pos == response.totalResults.toInt()) null else pos + 1
            )
        } catch (e : Exception) {
            LoadResult.Error(e)
        }
    }

}