package com.luiz.tmdbclient.data.repository.tvshow.datasourceimpl

import com.luiz.tmdbclient.data.api.TMDBService
import com.luiz.tmdbclient.data.model.tvshow.TvShowList
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
):TvShowRemoteDatasource {
    override suspend fun getTvShow(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}