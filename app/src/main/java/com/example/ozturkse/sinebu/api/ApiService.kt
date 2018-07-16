package com.example.ozturkse.sinebu.api

import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbApiService {


    @GET("discover/movie?sort_by=popularity.desc")
    fun getPopular(): Observable<TheMovieDbApiResponse>

    @GET("discover/movie?sort_by=vote_average.desc")
    fun getTopRated(): Observable<TheMovieDbApiResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(): Observable<TheMovieDbApiResponse>

    @GET("search/movie")
    fun getSearchMovies(@Query("query") query: String): Observable<TheMovieDbApiResponse>

    companion object {


        fun create(): TheMovieDbApiService {
            val baseUrl = "https://api.themoviedb.org/3/"

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(ApiKeyInterceptor())
                    .build()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .build()

            return retrofit.create(TheMovieDbApiService::class.java)
        }
    }
}