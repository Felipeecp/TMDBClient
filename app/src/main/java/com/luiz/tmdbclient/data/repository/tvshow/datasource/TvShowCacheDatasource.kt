package com.luiz.tmdbclient.data.repository.tvshow.datasource

import com.luiz.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDatasource {

    suspend fun getTvShowFromCache():List<TvShow>

    suspend fun saveTvShowToCache(tvShowList: List<TvShow>)

}