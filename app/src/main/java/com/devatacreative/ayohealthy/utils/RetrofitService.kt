package com.devatacreative.ayohealthy.utils

import com.devatacreative.ayohealthy.APIInterfaces.FoodRecommendation
import com.devatacreative.ayohealthy.APIInterfaces.Login
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    const val BASE_URL = "http://192.168.1.104/ayohealthy/public/api/"
    const val BASE_FOOD_URL = "https://groovy-analyst-314808.et.r.appspot.com/"
    private val okHttpClient = OkHttpClient.Builder().retryOnConnectionFailure(true).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    private val retrofitFood = Retrofit.Builder()
        .baseUrl(BASE_FOOD_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    fun<T> retrofitBuild(service: Class<T>): T {
        return when(service.canonicalName){
            Login::class.java.canonicalName -> {
                retrofit.create(service)
            }
            FoodRecommendation::class.java.canonicalName -> {
                retrofitFood.create(service)
            }
            else -> {
                retrofit.create(service)
            }
        }
    }

}