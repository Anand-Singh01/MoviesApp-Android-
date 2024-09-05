package com.example.moviesapp.model.dto

data class TrendingMoviesAndTvShowsListDto(
    val page: Int,
    val results: List<TrendingMoviesAndTvShowsDto>,
    val total_pages: Int,
    val total_results: Int
)