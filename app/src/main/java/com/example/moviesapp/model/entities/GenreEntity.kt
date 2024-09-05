package com.example.moviesapp.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre_tbl")
data class GenreEntity(

    @PrimaryKey val id: Int,
    val name: String
)
