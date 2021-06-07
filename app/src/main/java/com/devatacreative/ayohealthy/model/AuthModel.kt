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

data class LoginModel(
    @SerializedName("name")
    val nickname: String?,
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("phone_number")
    val phoneNumber: String?,
    @SerializedName("api_token")
    val apiToken: String?,
    @SerializedName("provider")
    val provider: String?,
    @SerializedName("provider_id")
    val providerID: String?
)
