package com.luiz.tmdbclient.data.repository.tvshow.datasourceimpl

import android.util.Log
import com.luiz.tmdbclient.data.model.tvshow.TvShow
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.luiz.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.luiz.tmdbclient.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource,
):TvShowRepository {
    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShow(): List<TvShow> {
        val newListOfTvShow = getTvShowFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowToDB(newListOfTvShow)
        tvShowCacheDatasource.saveTvShowToCache(newListOfTvShow)
        return newListOfTvShow
    }

    private suspend fun getTvShowFromAPI():List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDatasource.getTvShow()
            val body = response.body()
            if(body!=null){
                tvShowList=body.tvShows
            }
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDatasource.getTvShowsFromDB()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowFromAPI()
            tvShowLocalDatasource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDatasource.getTvShowFromCache()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}