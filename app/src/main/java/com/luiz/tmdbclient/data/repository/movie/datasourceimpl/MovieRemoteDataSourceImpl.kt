package com.luiz.tmdbclient.data.repository.movie.datasourceimpl

import com.luiz.tmdbclient.data.api.TMDBService
import com.luiz.tmdbclient.data.model.movie.MovieList
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String,
): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}