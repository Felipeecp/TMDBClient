package com.luiz.tmdbclient.presentation.di.tvshow

import com.luiz.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.luiz.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.luiz.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}