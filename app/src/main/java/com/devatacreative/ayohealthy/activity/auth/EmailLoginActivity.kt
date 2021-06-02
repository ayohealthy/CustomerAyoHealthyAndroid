package com.devatacreative.ayohealthy.activity.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devatacreative.ayohealthy.databinding.ActivityEmailLoginBinding

class EmailLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponent()
    }

    private fun initComponent(){
        binding.loginBackBtn.setOnClickListener {
            finish()
        }
        binding.forgotPasswordTextBtn.setOnClickListener {
            startActivity(Intent(this@EmailLoginActivity, ForgotPasswordActivity::class.java))
        }
    }
}