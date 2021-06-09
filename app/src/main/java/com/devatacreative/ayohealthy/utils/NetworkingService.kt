package com.devatacreative.ayohealthy.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.devatacreative.ayohealthy.APIInterfaces.Login
import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkingService(private val context: Context) {
    private val loginDatas = MutableLiveData<AuthModel>()
    fun login(loginData: LoginModel): MutableLiveData<AuthModel> {
        val retrofit = RetrofitService.retrofitBuild(Login::class.java)
        var authResult: AuthModel
        val call = retrofit.postLogin(loginData)
        call.enqueue(object : Callback<AuthModel> {
            override fun onResponse(call: Call<AuthModel>, response: Response<AuthModel>) {
                if (response.isSuccessful) {
                    val results = response.body()
                    loginDatas.postValue(results!!)
                }
                Log.d("isi response : ", response.body().toString() + response.code())
            }

            override fun onFailure(call: Call<AuthModel>, t: Throwable) {
                Log.e("isi LoginData: ", loginData.toString())
                Log.e("isi onFail: ", t.localizedMessage)
                Handler(Looper.getMainLooper()).postDelayed({
                    Toast.makeText(context, t.localizedMessage, Toast.LENGTH_LONG).show()
                    login(loginData)
                }, 3000)
            }
        })
        return loginDatas
    }
}