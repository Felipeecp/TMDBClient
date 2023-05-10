package com.luiz.tmdbclient.data.repository.movie.datasourceimpl

import android.util.Log
import com.luiz.tmdbclient.data.model.movie.Movie
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.luiz.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.luiz.tmdbclient.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDatasource: MovieCacheDatasource
): MovieRepository{


    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMovieFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newListOfMovies)
        movieCacheDatasource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMovieFromAPI():List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if(body!=null){
                movieList=body.movies
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        return movieList
    }

    private suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDatasource.getMoviesFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMovieFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    private suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDatasource.getMoviesFromCache()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDatasource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}