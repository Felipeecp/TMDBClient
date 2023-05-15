package com.luiz.tmdbclient.presentation.di.movie

import com.luiz.tmdbclient.domain.usecase.GetMoviesUseCase
import com.luiz.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.luiz.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}