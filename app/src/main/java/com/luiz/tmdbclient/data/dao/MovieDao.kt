package com.luiz.tmdbclient.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luiz.tmdbclient.data.model.movie.Movie
import com.luiz.tmdbclient.data.model.movie.MovieList

@Dao
interface MovieDao {

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies():List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

}