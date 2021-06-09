package com.devatacreative.ayohealthy.APIInterfaces

import com.devatacreative.ayohealthy.model.FNBRelatedMenu
import com.devatacreative.ayohealthy.model.UserMenuRecommendation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodRecommendation {
    @GET("recommendation_fnb/{food_code}")
    fun getRelatedMenu(
        @Path("food_code")
        foodCode: Int
    ): Call<FNBRelatedMenu>

    @GET("recommendation/{id}")
    fun getUserMenuRecommendation(
        @Path("id")
        userId: Int
    ): Call<UserMenuRecommendation>

}