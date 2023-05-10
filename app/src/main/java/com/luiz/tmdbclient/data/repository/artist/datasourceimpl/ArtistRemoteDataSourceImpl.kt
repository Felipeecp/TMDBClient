package com.luiz.tmdbclient.data.repository.artist.datasourceimpl

import com.luiz.tmdbclient.data.api.TMDBService
import com.luiz.tmdbclient.data.model.artist.ArtistList
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ):ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}