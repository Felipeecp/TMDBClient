package com.luiz.tmdbclient.domain.usecase

import com.luiz.tmdbclient.data.model.artist.Artist
import com.luiz.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}