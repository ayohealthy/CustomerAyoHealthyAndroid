package com.devatacreative.ayohealthy.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.devatacreative.ayohealthy.APIInterfaces.FoodRecommendation
import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.FNBRelatedMenu
import com.devatacreative.ayohealthy.model.LoginModel
import com.devatacreative.ayohealthy.model.UserMenuRecommendation
import com.devatacreative.ayohealthy.utils.NetworkingService
import com.devatacreative.ayohealthy.utils.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val networkHelper: NetworkingService){

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(helper: NetworkingService): RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun sendLoginData(loginData: LoginModel): MutableLiveData<AuthModel> = networkHelper.login(loginData)
    fun getMenuList(callback: GetRelatedMenu){
        val retrofit = RetrofitService.retrofitBuild(FoodRecommendation::class.java).getRelatedMenu(27150410)
        retrofit.enqueue(object : retrofit2.Callback<FNBRelatedMenu> {
            override fun onResponse(
                call: Call<FNBRelatedMenu>,
                response: Response<FNBRelatedMenu>
            ) {
                if (response.isSuccessful){
                    val results = response.body()
                    if (results != null) {
                        callback.onGetMenu(results)
                    }
                }
            }

            override fun onFailure(call: Call<FNBRelatedMenu>, t: Throwable) {
                Log.e("isi onFail: ", t.localizedMessage)
            }
        })
    }
    fun getUserRecommendation(callback: GetUserRecommendationMenu){
        val retrofit = RetrofitService.retrofitBuild(FoodRecommendation::class.java).getUserMenuRecommendation(1)
        retrofit.enqueue(object : Callback<UserMenuRecommendation>{
            override fun onResponse(
                call: Call<UserMenuRecommendation>,
                response: Response<UserMenuRecommendation>
            ) {
                if (response.isSuccessful){
                    response.body()?.let { callback.onGetmenu(it) }
                }
            }

            override fun onFailure(call: Call<UserMenuRecommendation>, t: Throwable) {
                Log.e("isi onFail: ", t.localizedMessage)
            }
        })
    }


    interface GetRelatedMenu{
        fun onGetMenu(recommendation: FNBRelatedMenu)
    }
    interface GetUserRecommendationMenu {
        fun onGetmenu(recommendation: UserMenuRecommendation)
    }
}