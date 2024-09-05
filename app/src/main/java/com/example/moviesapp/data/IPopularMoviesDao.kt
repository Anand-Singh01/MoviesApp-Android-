package com.example.moviesapp.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.moviesapp.model.entities.PopularMovieEntity

@Dao
interface IPopularMoviesDao {
    //Movies
    @Upsert
    suspend fun upsertPopularMovieList(movieList: List<PopularMovieEntity>)

    @Query("SELECT * FROM popular_movies_tbl WHERE id = :id")
    suspend fun getMovieById(id:Int) : PopularMovieEntity

    @Query("SELECT * FROM popular_movies_tbl WHERE category = :category")
    suspend fun getMoviesByCategory(category:String) : List<PopularMovieEntity>

    @Query("SELECT * FROM popular_movies_tbl WHERE page = :page")
    suspend fun getPopularMoviesByPageNumber(page:Int) : List<PopularMovieEntity>
}