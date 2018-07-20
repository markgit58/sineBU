package com.example.ozturkse.sinebu.api

import com.example.ozturkse.sinebu.model.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TheMovieDbApiResponse {

    @SerializedName("results")
    @Expose
    var movies: List<Movie>? = null

}