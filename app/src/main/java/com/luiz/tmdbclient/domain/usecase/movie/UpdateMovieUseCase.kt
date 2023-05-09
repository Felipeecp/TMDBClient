package com.luiz.tmdbclient.domain.usecase.movie

import com.luiz.tmdbclient.data.model.movie.Movie
import com.luiz.tmdbclient.domain.repository.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie> = movieRepository.updateMovies()

}