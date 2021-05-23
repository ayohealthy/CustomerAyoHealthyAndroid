package com.devatacreative.ayohealthy.utils

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.devatacreative.ayohealthy.interfaces.Login
import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkingService {
    val loginDatas = MutableLiveData<AuthModel>()
    fun login(loginData: LoginModel, onResult: (AuthModel?, Throwable?) -> Unit) {
        val retrofit = RetrofitService.retrofitBuild(Login::class.java)
        retrofit.postLogin(loginData).enqueue(object : Callback<AuthModel> {
            override fun onResponse(call: Call<AuthModel>, response: Response<AuthModel>) {
                onResult(response.body(), null)
                if (response.body() != null ){
                    loginDatas.value = AuthModel( response.body()!!.success, response.body()!!.message, response.body()!!.data, response.body()!!.code)
                }
                Log.d("isi response : ", response.body().toString() + response.code())
            }

            override fun onFailure(call: Call<AuthModel>, t: Throwable) {
                onResult(null, t)
                Log.e("isi LoginData: ", loginData.toString())

                Log.e("isi onFail: ", t.localizedMessage)
            }
        })
    }

}