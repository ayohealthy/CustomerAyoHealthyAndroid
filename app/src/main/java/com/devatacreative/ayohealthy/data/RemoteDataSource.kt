package com.devatacreative.ayohealthy.data

import androidx.lifecycle.LiveData
import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel
import com.devatacreative.ayohealthy.utils.NetworkingService

class RemoteDataSource private constructor(private val networkHelper: NetworkingService){

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(helper: NetworkingService): RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun sendLoginData(loginData: LoginModel): LiveData<AuthModel> = networkHelper.login(loginData)
}