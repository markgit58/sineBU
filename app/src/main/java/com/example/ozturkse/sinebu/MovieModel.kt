package com.example.ozturkse.sinebu

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

    @SerializedName("vote_average")
    @Expose
    var rating: Float = 0.toFloat()

    @SerializedName("genre_ids")
    @Expose
    var genreIds: List<Int>? = null

    fun getPosterUrl(): String {
        return "https://image.tmdb.org/t/p/w342$posterPath"
    }
}

class TheMovieDbApiResponse {

    @SerializedName("page")
    @Expose
    var page: Int = 0

    @SerializedName("total_results")
    @Expose
    var totalResults: Int = 0

    @SerializedName("results")
    @Expose
    var movies: List<Movie>? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int = 0


}