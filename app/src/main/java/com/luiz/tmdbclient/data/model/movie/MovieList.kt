package com.luiz.tmdbclient.data.model.movie
import com.google.gson.annotations.SerializedName
import com.luiz.tmdbclient.data.model.movie.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>,
)