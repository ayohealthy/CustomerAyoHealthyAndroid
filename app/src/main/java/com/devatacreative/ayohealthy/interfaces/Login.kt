package com.devatacreative.ayohealthy.interfaces

import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Login {

    @POST("AuthDataSource/sso")
    fun postLogin(@Body login: LoginModel): Call<AuthModel>



}