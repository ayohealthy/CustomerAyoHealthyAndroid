package com.devatacreative.ayohealthy.model

import com.google.gson.annotations.SerializedName

data class AuthModel(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: LoginModel,
    @SerializedName("code")
    val code: Int
)