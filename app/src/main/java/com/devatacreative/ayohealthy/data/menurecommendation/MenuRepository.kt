package com.devatacreative.ayohealthy.data.menurecommendation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devatacreative.ayohealthy.data.RemoteDataSource
import com.devatacreative.ayohealthy.model.FNBRelatedMenu
import com.devatacreative.ayohealthy.model.RelatedFoodItem
import com.devatacreative.ayohealthy.model.UserMenuRecommendation
import kotlin.Exception

class MenuRepository private constructor(private  val remoteDataSource: RemoteDataSource):
    MenuDataSource {
    companion object{
        @Volatile
        private var instance: MenuRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MenuRepository =
            instance ?: synchronized(this){
                instance ?: MenuRepository(remoteData).apply { instance = this }
            }
    }

    private var menuList = MutableLiveData<FNBRelatedMenu>()
    private var userRecommendation = MutableLiveData<UserMenuRecommendation>()
    override fun getRelatedMenu(): LiveData<FNBRelatedMenu> {
        remoteDataSource.getMenuList(object : RemoteDataSource.GetRelatedMenu{
            override fun onGetMenu(recommendation: FNBRelatedMenu) {
                try {
                    menuList.postValue(recommendation)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        })
        return menuList
    }

    override fun getUserRecommendationMenu(): LiveData<UserMenuRecommendation> {
        remoteDataSource.getUserRecommendation(object : RemoteDataSource.GetUserRecommendationMenu{
            override fun onGetmenu(recommendation: UserMenuRecommendation) {
                try {
                    userRecommendation.postValue(recommendation)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        })
        return userRecommendation
    }

}