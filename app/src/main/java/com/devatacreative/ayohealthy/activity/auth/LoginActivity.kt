package com.devatacreative.ayohealthy.activity.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.devatacreative.ayohealthy.activity.MainActivity
import com.devatacreative.ayohealthy.databinding.ActivityLoginBinding
import com.devatacreative.ayohealthy.model.AuthModel
import com.devatacreative.ayohealthy.model.LoginModel
import com.devatacreative.ayohealthy.utils.GlobalHelper
import com.devatacreative.ayohealthy.viewmodel.LoginViewModel
import com.devatacreative.ayohealthy.viewmodel.ViewModelFactory
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var signInClient: GoogleSignInClient
    private lateinit var loginViewModel: LoginViewModel
    private val RC_SIGN_IN = 1
    private lateinit var authData: AuthModel


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initComponent()

    }

    override fun onStart() {
        super.onStart()
        //Check existing Signed-in User
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account != null) {
            //What to do if user exist
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login() {
        GlobalHelper().showLoading(binding.loadingLayout, binding.loadingAnimation, true)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestProfile()
            .build()
        signInClient = GoogleSignIn.getClient(this, gso)
        val intent = signInClient.signInIntent
        startActivityForResult(intent, RC_SIGN_IN)

        //post login data to backend

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
//                val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                val account = GoogleSignIn.getLastSignedInAccount(this)
                val accModel = LoginModel(account?.displayName, account?.photoUrl.toString(), account?.email, "0000000000", "123", "gmail", "123")

                loginViewModel.authenticationLogin(accModel).observe(this, {
                    Log.e("isi AuthModel : ", it.success.toString())
                })
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            } catch (e: ApiException) {
                Log.e("KESALAHAN ", "SignInResult Failed Code : " + e.statusCode.toString())
            }
        }
        GlobalHelper().showLoading(binding.loadingLayout, binding.loadingAnimation, false)
    }

    private fun initComponent() {
        val factory = ViewModelFactory.getInstance(baseContext)
        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        binding.forgotPasswordTextButton.setOnClickListener {
            Toast.makeText(this, "Lupa kata sandi", Toast.LENGTH_SHORT).show()
        }
        binding.googleSignInBtn.setStyle(SignInButton.SIZE_WIDE, SignInButton.COLOR_DARK)
        binding.googleSignInBtn.setOnClickListener {
            login()
        }
        binding.registerTextLink.setOnClickListener {
        }
    }


}