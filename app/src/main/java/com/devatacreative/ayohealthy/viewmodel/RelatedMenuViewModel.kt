package com.devatacreative.ayohealthy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.devatacreative.ayohealthy.data.menurecommendation.MenuRepository
import com.devatacreative.ayohealthy.model.FNBRelatedMenu

class RelatedMenuViewModel(private val menuRepository: MenuRepository): ViewModel() {
    fun loadRelatedMenuItems(): LiveData<FNBRelatedMenu> = menuRepository.getRelatedMenu()
}