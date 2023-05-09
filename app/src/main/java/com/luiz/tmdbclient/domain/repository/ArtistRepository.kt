package com.luiz.tmdbclient.domain.repository

import com.luiz.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists():List<Artist>

    suspend fun updateArtistis():List<Artist>

}