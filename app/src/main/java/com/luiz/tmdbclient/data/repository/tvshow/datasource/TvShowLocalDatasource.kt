package com.luiz.tmdbclient.data.repository.tvshow.datasource

import com.luiz.tmdbclient.data.model.tvshow.TvShow
import com.luiz.tmdbclient.data.model.tvshow.TvShowList

interface TvShowLocalDatasource {

    suspend fun getTvShowsFromDB():List<TvShow>

    suspend fun saveTvShowToDB(tvShowList: List<TvShow>)

    suspend fun clearAll()

}