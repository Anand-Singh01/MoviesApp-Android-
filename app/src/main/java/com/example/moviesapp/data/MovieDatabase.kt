package com.example.moviesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.model.entities.GenreEntity
import com.example.moviesapp.model.entities.PopularMovieEntity
import com.example.moviesapp.model.entities.TrendingMoviesAndTvShowsEntity

@Database(entities = [PopularMovieEntity::class,
    GenreEntity::class, TrendingMoviesAndTvShowsEntity::class],
    version = 1,
    exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): IPopularMoviesDao
    abstract fun genreDao(): IGenreDao
}