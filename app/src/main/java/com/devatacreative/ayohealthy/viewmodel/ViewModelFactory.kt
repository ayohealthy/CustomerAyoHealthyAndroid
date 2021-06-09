package com.devatacreative.ayohealthy.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devatacreative.ayohealthy.data.auth.AuthRepository
import com.devatacreative.ayohealthy.data.menurecommendation.MenuRepository
import com.devatacreative.ayohealthy.di.Injection

class ViewModelFactory private constructor(private val authRepository: AuthRepository, private val menuRepository : MenuRepository): ViewModelProvider.NewInstanceFactory(){
    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this){
                ViewModelFactory(Injection.provideAuthRepository(context), Injection.provideMenuRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(authRepository) as T
            }
            modelClass.isAssignableFrom(RelatedMenuViewModel::class.java) -> {
                RelatedMenuViewModel(menuRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class : " + modelClass.name)
        }
    }
}