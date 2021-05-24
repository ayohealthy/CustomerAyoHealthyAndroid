package com.devatacreative.ayohealthy.data.auth

import androidx.lifecycle.LiveData
import com.devatacreative.ayohealthy.data.RemoteDataSource
import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel
import com.google.android.gms.auth.api.Auth

class AuthRepository private constructor(private  val remoteDataSource: RemoteDataSource): AuthDataSource{

    companion object{
        @Volatile
        private var instance: AuthRepository? = null
        fun getInstance(remoteData: RemoteDataSource):AuthRepository =
            instance ?: synchronized(this){
                instance ?: AuthRepository(remoteData).apply { instance = this }
            }
    }

    override fun sendLoginData(loginModel: LoginModel): LiveData<AuthModel> {
        return remoteDataSource.sendLoginData(loginModel)

    }

}