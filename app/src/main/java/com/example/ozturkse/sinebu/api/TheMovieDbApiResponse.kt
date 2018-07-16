package com.example.ozturkse.sinebu.api

import com.example.ozturkse.sinebu.model.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

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