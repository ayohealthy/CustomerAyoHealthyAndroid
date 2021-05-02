package com.devatacreative.ayohealthy.activity.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devatacreative.ayohealthy.databinding.ActivityLoginBinding
import com.google.android.gms.common.SignInButton

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
       initComponent()
    }

    private fun initComponent(){
        binding.forgotPasswordTextButton.setOnClickListener{
            Toast.makeText(this, "Lupa kata sandi", Toast.LENGTH_SHORT).show()
        }
        binding.googleSignInBtn.setStyle(SignInButton.SIZE_STANDARD, SignInButton.COLOR_LIGHT)
        binding.googleSignInBtn.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
    }

}