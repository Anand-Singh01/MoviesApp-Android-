package com.example.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.data.IGenreDao
import com.example.moviesapp.data.IPopularMoviesDao
import com.example.moviesapp.data.MovieDatabase
import com.example.moviesapp.network.IMoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): MovieDatabase =
        Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movie_db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideWeatherApi() : IMoviesApi{
        return Retrofit.Builder()
            .baseUrl(com.example.moviesapp.utils.Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IMoviesApi::class.java)
    }

    @Singleton
    @Provides
    fun getMovieDao(db: MovieDatabase): IPopularMoviesDao = db.movieDao()

    @Singleton
    @Provides
    fun getGenreDao(db: MovieDatabase): IGenreDao = db.genreDao()
}