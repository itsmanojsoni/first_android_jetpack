package com.example.manojsoni.interview.network



import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {

    const val baseUrl = "http://api.themoviedb.org/3/"
    private val MOVIES_BASE_URL = "http://eng-assets.s3-website-us-west-2.amazonaws.com"

    private val retrofit: Retrofit = Builder()
        .baseUrl(MOVIES_BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: NetworkApi = retrofit.create(NetworkApi::class.java)
}