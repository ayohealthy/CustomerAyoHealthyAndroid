package com.devatacreative.ayohealthy.activity.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.devatacreative.ayohealthy.activity.MainActivity
import com.devatacreative.ayohealthy.databinding.ActivityLoginPickBinding
import com.devatacreative.ayohealthy.model.LoginModel
import com.devatacreative.ayohealthy.utils.GlobalHelper
import com.devatacreative.ayohealthy.viewmodel.LoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.internal.SignInButtonConfig

class LoginPickActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPickBinding
    private lateinit var signInClient: GoogleSignInClient
    private lateinit var loginViewModel: LoginViewModel

    companion object{
        private val RC_SIGN_IN = 1
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
        if (account != null){
            val intent = Intent(this@LoginPickActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun login(){
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
        if (requestCode == RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = GoogleSignIn.getLastSignedInAccount(this)
                val accModel = LoginModel(account?.displayName, account?.photoUrl.toString(), account?.email, "0000000000", "123", "gmail", "123")

            }catch (e: ApiException){

            }
        }
    }

    private fun initComponent(){
        binding.googleAuthBtn.setStyle(SignInButton.SIZE_WIDE, SignInButton.COLOR_LIGHT)
        binding.googleAuthBtn.setOnClickListener {
            login()
        }

        binding.pickLoginTextBtn.setOnClickListener {
            val intent = Intent(this@LoginPickActivity, EmailLoginActivity::class.java)
            startActivity(intent)
        }
    }
}