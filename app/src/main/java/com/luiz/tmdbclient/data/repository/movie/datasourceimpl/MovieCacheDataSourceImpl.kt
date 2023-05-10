package com.luiz.tmdbclient.data.repository.movie.datasourceimpl

import com.luiz.tmdbclient.data.model.movie.Movie
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDataSourceImpl: MovieCacheDatasource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}