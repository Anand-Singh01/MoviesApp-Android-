package com.example.moviesapp.utils

import com.example.moviesapp.data.IGenreDao
import com.example.moviesapp.model.dto.GenreDto
import com.example.moviesapp.model.dto.MovieDto
import com.example.moviesapp.model.entities.GenreEntity
import com.example.moviesapp.model.entities.PopularMovieEntity

suspend fun MovieDto.toEntity(genreDao: IGenreDao, page: Int): PopularMovieEntity {
    val genreNames = genreDao.getGenreName(this.genre_ids)
    val genreString = genreNames.joinToString(separator = " / ")

    return PopularMovieEntity(
        id = id,
        adult = adult,
        backdrop_path = backdrop_path,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count,
        category = genreString,
        page = page
    )
}

suspend fun GenreDto.toEntity() : GenreEntity{
    return GenreEntity(
        id = this.id,
        name = this.name
    )
}