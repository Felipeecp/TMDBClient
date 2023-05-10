package com.luiz.tmdbclient.data.repository.tvshow.datasourceimpl

import com.luiz.tmdbclient.data.model.tvshow.TvShow
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDataSourceImpl:TvShowCacheDatasource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}