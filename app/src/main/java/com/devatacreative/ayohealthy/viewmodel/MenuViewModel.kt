package com.devatacreative.ayohealthy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.devatacreative.ayohealthy.data.menurecommendation.MenuRepository
import com.devatacreative.ayohealthy.model.FNBRelatedMenu
import com.devatacreative.ayohealthy.model.UserMenuRecommendation

class MenuViewModel(private val menuRepository: MenuRepository): ViewModel() {
    fun loadRelatedMenuItems(): LiveData<FNBRelatedMenu> = menuRepository.getRelatedMenu()
    fun loadUserRecommendationItems(): LiveData<UserMenuRecommendation> = menuRepository.getUserRecommendationMenu()
}