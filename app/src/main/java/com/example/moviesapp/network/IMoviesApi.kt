package com.example.moviesapp.network

import com.example.moviesapp.model.dto.GenreListDto
import com.example.moviesapp.model.dto.MovieListDto
import com.example.moviesapp.model.dto.TrendingMoviesAndTvShowsDto
import com.example.moviesapp.model.dto.TrendingMoviesAndTvShowsListDto
import com.example.moviesapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface IMoviesApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page:Int,
        @Query("api_key") apiKey:String = Constants.API_KEY,
    ) : MovieListDto

    @GET("genre/movie/list")
    suspend fun getGenreList(
        @Query("api_key") apiKey:String = Constants.API_KEY,
    ) : GenreListDto

    //trending/all/day
    @GET("trending/all/day")
    suspend fun getTrendingMoviesList(
        @Query("api_key") apiKey:String = Constants.API_KEY,
    ) : TrendingMoviesAndTvShowsListDto
}