package com.example.ozturkse.sinebu.api

import com.example.ozturkse.sinebu.model.TheMovieDbApiResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbApiService {

    private val apikey = "65dd7f149cc5dc1f35fbedbc35c534ed"

    @GET("discover/movie?sort_by=popularity.desc")
    fun getPopular(@Query("api_key") apiKey: String): Observable<TheMovieDbApiResponse>

    @GET("discover/movie?sort_by=vote_average.desc")
    fun getTopRated(@Query("api_key") apiKey: String): Observable<TheMovieDbApiResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(
            @Query("api_key") api_key: String): Observable<TheMovieDbApiResponse>

    @GET("search/movie")
    fun getSearchMovies(
            @Query("api_key") api_key: String,
            @Query("query") query: String): Observable<TheMovieDbApiResponse>

    companion object {


        fun create(baseUrl: String): TheMovieDbApiService {
            private val baseUrl = "https://api.themoviedb.org/3/"

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .build()

            return retrofit.create(TheMovieDbApiService::class.java)
        }
    }
}