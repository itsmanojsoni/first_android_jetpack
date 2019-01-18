package com.example.manojsoni.interview.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

public interface NetworkApi {


    @GET("movie/now_playing")
    fun getLatestMovies(@Query("api_key") apiKey : String) : Observable<List<Movie>>

    @GET("/fixture/movies.json")
    fun getMovieList(): Observable<List<Movie>>

}