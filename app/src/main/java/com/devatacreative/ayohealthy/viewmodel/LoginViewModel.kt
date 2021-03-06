package com.devatacreative.ayohealthy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.devatacreative.ayohealthy.data.auth.AuthRepository
import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel

class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {

    fun authenticationLogin(loginModel: LoginModel): LiveData<AuthModel> = authRepository.sendLoginData(loginModel)


//    fun userLogin(
//        context: Context,
//        loginModel: LoginModel
//    ) : LiveData<AuthModel>{
//        NetworkingService(context).login(loginModel){ authModel, err ->
//            if (authModel != null){
//                login.postValue(authModel)
//                Toast.makeText(context, "Login Success", Toast.LENGTH_LONG).show()
//            } else {
//                Toast.makeText(context, err?.localizedMessage, Toast.LENGTH_LONG ).show()
//            }
//        }
//        return login
//    }

}