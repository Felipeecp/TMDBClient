package com.luiz.tmdbclient.domain.usecase

import com.luiz.tmdbclient.data.model.movie.Movie
import com.luiz.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
  suspend fun execute():List<Movie>? = movieRepository.getMovies()
}