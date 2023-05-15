package com.luiz.tmdbclient.domain.usecase

import com.luiz.tmdbclient.data.model.tvshow.TvShow
import com.luiz.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowRepository.updateTvShows()
}