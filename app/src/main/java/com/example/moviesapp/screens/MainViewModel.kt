package com.example.moviesapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.DataOrException
import com.example.moviesapp.model.entities.PopularMovieEntity
import com.example.moviesapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val _popularMoviesList =
        MutableStateFlow(DataOrException<List<PopularMovieEntity>, Boolean, Exception>())
    val popularMoviesList : StateFlow<DataOrException<List<PopularMovieEntity>, Boolean, Exception>>
     = _popularMoviesList

    private val _trendingImagesList =
        MutableStateFlow(DataOrException<List<String>, Boolean, Exception>())
    val trendingImagesList : StateFlow<DataOrException<List<String>, Boolean, Exception>>
            = _trendingImagesList

    init {
        updateTrendingImagesList()
    }
    private fun updateMoviesList(page:Int = 1){
        _popularMoviesList.value.isLoading = true
        viewModelScope.launch {
            _popularMoviesList.value = repository.getPopularMoviesListByPageNumber(page)
        }
    }
    private fun updateTrendingImagesList(){
        _trendingImagesList.value.isLoading = true
        viewModelScope.launch {
            _trendingImagesList.value = repository.getTrendingMoviesAndTvShowsImages()
        }
    }
}