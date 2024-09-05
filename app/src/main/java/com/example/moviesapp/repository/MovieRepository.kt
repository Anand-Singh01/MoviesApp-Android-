package com.example.moviesapp.repository

import com.example.moviesapp.data.DataOrException
import com.example.moviesapp.data.IGenreDao
import com.example.moviesapp.data.IPopularMoviesDao
import com.example.moviesapp.model.entities.PopularMovieEntity
import com.example.moviesapp.network.IMoviesApi
import com.example.moviesapp.utils.Constants
import com.example.moviesapp.utils.toEntity
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: IMoviesApi,
    private val movieDao: IPopularMoviesDao,
    private val genreDao: IGenreDao
) {

    suspend fun getPopularMoviesListByPageNumber(
        page: Int
    ): DataOrException<List<PopularMovieEntity>, Boolean, Exception> {

        val dataOrException =
            DataOrException<List<PopularMovieEntity>, Boolean, Exception>()
        try {
            ensureGenreTableExists()
            val movies: List<PopularMovieEntity> = movieDao.getPopularMoviesByPageNumber(page)
            if (movies.isNotEmpty()) {
                dataOrException.data = movies
            } else {
                val movieListDto = api.getPopularMovies(page)
                movieListDto.let {
                    val movieEntities = it.results.map { movieDto ->
                        movieDto.toEntity(genreDao, page)
                    }
                    movieDao.upsertPopularMovieList(movieEntities)
                    dataOrException.data = movieEntities
                }
            }
        } catch (exception: Exception) {
            dataOrException.e = exception
        } finally {
            dataOrException.isLoading = false
        }
        return dataOrException
    }

    private suspend fun ensureGenreTableExists() {
        if (genreDao.getGenreCount() == 0) {
            val genreListDto = api.getGenreList()
            genreListDto.let {
                val genreEntities = it.genres.map { genreDto ->
                    genreDto.toEntity()
                }
                genreDao.upsertGenreList(genreEntities)
            }
        }
    }

    suspend fun getTrendingMoviesAndTvShowsImages():
            DataOrException<List<String>, Boolean, Exception> {

        val dataOrException =
            DataOrException<List<String>,
                    Boolean,
                    Exception>()
        try {
            val content = api.getTrendingMoviesList()
            val images = content.let { trendingMoviesAndTvShowsListDto ->
                trendingMoviesAndTvShowsListDto.results.map {
                    Constants.IMAGE_BASE_URL + it.poster_path
                }.take(5)
            }
            dataOrException.data = images

        } catch (exception: Exception) {
            dataOrException.e = exception
        } finally {
            dataOrException.isLoading = false
        }
        return dataOrException
    }

    private suspend fun getTrendingMoviesAndTvShowsList() {

    }
}