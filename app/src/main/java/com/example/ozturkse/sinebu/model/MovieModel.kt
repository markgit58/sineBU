package com.example.ozturkse.sinebu.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null


    @SerializedName("vote_average")
    @Expose
    var rating: Float = 0.toFloat()

    @SerializedName("genre_ids")
    @Expose
    var genreIds: List<Int>? = null

    private val BASE_POSTER_URL = "https://image.tmdb.org/t/p/w342"
    val BASE_BACKDROP_URL = "httpS://image.tmdb.org/t/p/w780"

    fun getPosterUrl(): String {
        return "$BASE_POSTER_URL$posterPath"
    }

    fun getBackdropUrl(): String {
        return "$BASE_BACKDROP_URL$backdropPath"
    }
}

