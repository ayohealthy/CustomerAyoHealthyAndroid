package com.devatacreative.ayohealthy.APIInterfaces

import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Login {

    @Headers("Content-Type: application/json")
    @POST("AuthDataSource/sso")
    fun postLogin(@Body login: LoginModel): Call<AuthModel>



}