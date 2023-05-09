package com.luiz.tmdbclient.data.api

import com.luiz.tmdbclient.data.model.artist.ArtistList
import com.luiz.tmdbclient.data.model.movie.MovieList
import com.luiz.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

class TMDBService {

    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey:String)
    :Response<MovieList>{
        TODO()
    }

    @GET("/tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apiKey:String)
    :Response<TvShowList>{
        TODO()
    }


    @GET("/person/popular")
    suspend fun getPopularArtists(
        @Query("api_key") apiKey:String)
    :Response<ArtistList>{
        TODO()
    }

}