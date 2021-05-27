package com.devatacreative.ayohealthy.data.auth

import androidx.lifecycle.MutableLiveData
import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel

interface AuthDataSource {
    fun sendLoginData(loginModel: LoginModel): MutableLiveData<AuthModel>
}