package com.example.manojsoni.interview.network

import com.google.gson.annotations.SerializedName

//data class Movie (
//
//    @SerializedName("poster_path") val posterPath : String,
//    @SerializedName("original_title") val title: String,
//    @SerializedName("overview") val overview: String,
//
//    @SerializedName("popularity") val popularity: Double,
//
//    @SerializedName("vote_average") val rating: Double,
//
//    @SerializedName("backdrop_path") val backdrop_path: String,
//
//    @SerializedName("id") val id: Int = 0
//)

data class Movie (
    val id: String,
    val title: String,
    val image: String
)

