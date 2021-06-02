package com.devatacreative.ayohealthy.utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    const val BASE_URL = "http://192.168.1.104/ayohealthy/public/api/"
    private val okHttpClient = OkHttpClient.Builder().retryOnConnectionFailure(true).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun<T> retrofitBuild(service: Class<T>): T {
        return retrofit.create(service)
    }
}