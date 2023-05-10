package com.luiz.tmdbclient.data.repository.movie.datasource

import com.luiz.tmdbclient.data.model.movie.Movie

interface MovieLocalDatasource {

    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()


}