package com.example.moviesapp.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.moviesapp.model.entities.GenreEntity

@Dao
interface IGenreDao {
    @Upsert
    suspend fun upsertGenreList(genreList:List<GenreEntity>)
    @Query("SELECT name FROM genre_tbl WHERE id IN (:genreId)")
    suspend fun getGenreName(genreId:List<Int>) : List<String>

    @Query("SELECT COUNT(*) FROM genre_tbl")
    suspend fun getGenreCount() : Int
}