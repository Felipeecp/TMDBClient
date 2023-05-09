package com.luiz.tmdbclient.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.luiz.tmdbclient.data.dao.ArtistDao
import com.luiz.tmdbclient.data.dao.MovieDao
import com.luiz.tmdbclient.data.dao.TvShowDao
import com.luiz.tmdbclient.data.model.artist.Artist
import com.luiz.tmdbclient.data.model.movie.Movie
import com.luiz.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){

    abstract fun movieDao():MovieDao
    abstract fun tvDao():TvShowDao
    abstract fun artistDao():ArtistDao

}