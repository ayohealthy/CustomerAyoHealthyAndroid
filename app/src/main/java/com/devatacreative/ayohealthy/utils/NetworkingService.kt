package com.devatacreative.ayohealthy.utils

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devatacreative.ayohealthy.interfaces.Login
import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkingService(private val context: Context){
    private val loginDatas = MutableLiveData<AuthModel>()
    fun login(loginData: LoginModel): MutableLiveData<AuthModel> {
        val retrofit = RetrofitService.retrofitBuild(Login::class.java)
        var authResult: AuthModel
        val call = retrofit.postLogin(loginData)
        call.enqueue(object : Callback<AuthModel> {
            override fun onResponse(call: Call<AuthModel>, response: Response<AuthModel>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        authResult = AuthModel(
                            response.body()!!.success,
                            response.body()!!.message,
                            response.body()!!.data,
                            response.body()!!.code
                        )
                        loginDatas.postValue(authResult)
                    }
                    Log.d("isi response : ", response.body().toString() + response.code())
                }
            }

            override fun onFailure(call: Call<AuthModel>, t: Throwable) {
                Log.e("isi LoginData: ", loginData.toString())
                Log.e("isi onFail: ", t.localizedMessage)
            }
        })
        return loginDatas
    }

}