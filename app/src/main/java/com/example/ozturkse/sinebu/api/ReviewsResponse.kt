package com.example.ozturkse.sinebu.api

import com.example.ozturkse.sinebu.model.Review
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ReviewResponse {

    @SerializedName("results")
    @Expose
    var reviews: List<Review>? = null

}