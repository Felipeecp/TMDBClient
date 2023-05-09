package com.luiz.tmdbclient.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luiz.tmdbclient.data.model.tvshow.TvShow
import com.luiz.tmdbclient.data.model.tvshow.TvShowList
import javax.inject.Inject

@Dao
interface TvShowDao {

    @Query("SELECT * FROM popular_tvshow")
    suspend fun getTvShows(tvShowList: List<TvShow>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShowList: List<TvShow>)

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteTvShow()

}