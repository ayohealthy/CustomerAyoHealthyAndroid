package com.devatacreative.ayohealthy.data.menurecommendation

import androidx.lifecycle.LiveData
import com.devatacreative.ayohealthy.model.FNBRelatedMenu
import com.devatacreative.ayohealthy.model.UserMenuRecommendation

interface MenuDataSource {
    fun getRelatedMenu():LiveData<FNBRelatedMenu>
    fun getUserRecommendationMenu(): LiveData<UserMenuRecommendation>
}