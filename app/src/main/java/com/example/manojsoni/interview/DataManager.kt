package com.example.manojsoni.interview

import com.example.manojsoni.interview.network.Movie
import com.example.manojsoni.interview.network.NetworkService.api
import io.reactivex.Observable

object DataManager {

    private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"

    fun loadMovies(): Observable<List<Movie>> {
        return api.getLatestMovies(API_KEY)
    }

    fun getMovieList(): Observable<List<Movie>> {
        return api.getMovieList()
    }


}