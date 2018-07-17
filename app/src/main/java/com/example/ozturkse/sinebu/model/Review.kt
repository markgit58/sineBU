package com.example.ozturkse.sinebu.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Review {

    @SerializedName("author")
    @Expose
    var author: String? = null

    @SerializedName("content")
    @Expose
    var content: String? = null
}