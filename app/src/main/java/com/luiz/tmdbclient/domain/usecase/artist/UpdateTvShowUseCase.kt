package com.luiz.tmdbclient.domain.usecase.artist

import com.luiz.tmdbclient.data.model.tvshow.TvShow
import com.luiz.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute():List<TvShow> = tvShowRepository.updateTvShow()

}