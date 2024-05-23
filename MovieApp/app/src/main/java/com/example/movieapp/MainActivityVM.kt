package com.example.movieapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityVM @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    val triggerSearch = MutableLiveData("")



    val movieList = triggerSearch.value?.let { movieRepository.getMovieList(it).cachedIn(viewModelScope) }


}