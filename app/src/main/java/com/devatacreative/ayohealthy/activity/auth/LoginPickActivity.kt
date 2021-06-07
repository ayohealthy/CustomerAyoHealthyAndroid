package com.devatacreative.ayohealthy.activity.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.devatacreative.ayohealthy.activity.mainmenu.MainActivity
import com.devatacreative.ayohealthy.databinding.ActivityLoginPickBinding
import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel
import com.devatacreative.ayohealthy.model.UserPrefModel
import com.devatacreative.ayohealthy.utils.GlobalHelper
import com.devatacreative.ayohealthy.utils.UserPref
import com.devatacreative.ayohealthy.viewmodel.LoginViewModel
import com.devatacreative.ayohealthy.viewmodel.ViewModelFactory
import com.google.android.gms.auth.api.signin.*
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Status

class LoginPickActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPickBinding
    private lateinit var signInClient: GoogleSignInClient
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var factory: ViewModelFactory

    companion object {
        private const val RC_SIGN_IN = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginPickBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initComponent()
    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account != null) {
            val intent = Intent(this@LoginPickActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        GlobalHelper().showLoading(binding.loadingLayer, binding.loading, true)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestProfile()
            .build()
        signInClient = GoogleSignIn.getClient(this, gso)
        val intent = signInClient.signInIntent

        startActivityForResult(intent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var authResult: AuthModel? = null
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                val accModel = LoginModel(
                    account?.displayName,
                    account?.photoUrl.toString(),
                    account?.email,
                    "0000000000",
                    "123",
                    "gmail",
                    "123"
                )
                val userModel = UserPrefModel(
                    account?.id,
                    account?.idToken,
                    account?.displayName,
                    account?.email,
                    account?.photoUrl.toString()
                )
                UserPref(this).setUser(userModel)
//                loginViewModel.authenticationLogin(accModel).observe(this, {
//                    Log.e("isi AuthModel : ", it.success.toString())
//                    authResult = it
//                    if (authResult != null) {
                        startActivity(Intent(this@LoginPickActivity, MainActivity::class.java))
//                        loginViewModel.authenticationLogin(accModel).removeObservers(this)
                        binding.loadingLayer.visibility = View.INVISIBLE
                        binding.loading.visibility = View.INVISIBLE
                        finish()
//                    }
//                })


            } catch (e: ApiException) {
                Log.e("KESALAHAN ", "SignInResult Failed Code : " + e.statusCode.toString())
            }
        }

    }

    private fun initComponent() {
        factory = ViewModelFactory.getInstance(baseContext)
        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        binding.googleAuthBtn.setStyle(SignInButton.SIZE_WIDE, SignInButton.COLOR_LIGHT)
        binding.googleAuthBtn.setOnClickListener {
            login()
        }
        binding.pickLoginTextBtn.setOnClickListener {
            val intent = Intent(this@LoginPickActivity, EmailLoginActivity::class.java)
            startActivity(intent)
        }
        binding.pickRegisterBtn.setOnClickListener {
            val intent = Intent(this@LoginPickActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}