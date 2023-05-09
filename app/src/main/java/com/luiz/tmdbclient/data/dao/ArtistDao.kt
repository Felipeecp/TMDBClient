package com.luiz.tmdbclient.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luiz.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(artists: List<Artist>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteArtist()

}