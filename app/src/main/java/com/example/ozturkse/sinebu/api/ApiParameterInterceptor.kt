package com.example.ozturkse.sinebu.api

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class ApiParameterInterceptor : Interceptor {

    private val api_key = "65dd7f149cc5dc1f35fbedbc35c534ed"
    private val language = Locale.getDefault().language.toString()
    private val country = Locale.getDefault().country.toString()
    private val api_language = language + '-' + country


    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url()
        val url = originalUrl.newBuilder()
                .addQueryParameter("api_key", api_key)
                .addQueryParameter("language", api_language)
                .build()

        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}