package com.devatacreative.ayohealthy.activity.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devatacreative.ayohealthy.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    
}