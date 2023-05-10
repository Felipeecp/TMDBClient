package com.luiz.tmdbclient.data.repository.artist.datasourceimpl

import android.util.Log
import com.luiz.tmdbclient.data.model.artist.Artist
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.luiz.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.luiz.tmdbclient.domain.repository.ArtistRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistCacheDatasource: ArtistCacheDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistRemoteDatasource: ArtistRemoteDatasource
):ArtistRepository {
    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtistis(): List<Artist> {
        val newListOfArtist = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtist)
        artistCacheDatasource.saveArtistsToCache(newListOfArtist)
        return newListOfArtist
    }

    private suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return artistList
    }

    private suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList : List<Artist>

        try {
            artistList = artistLocalDatasource.getArtistsFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if(artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    private suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDatasource.getArtistsFromCache()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if(artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}