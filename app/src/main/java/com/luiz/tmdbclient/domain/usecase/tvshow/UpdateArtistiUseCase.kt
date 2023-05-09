package com.luiz.tmdbclient.domain.usecase.tvshow

import com.luiz.tmdbclient.data.model.artist.Artist
import com.luiz.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistiUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist> = artistRepository.updateArtistis()

}