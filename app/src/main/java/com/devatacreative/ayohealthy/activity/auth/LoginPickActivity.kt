package com.devatacreative.ayohealthy.activity.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devatacreative.ayohealthy.databinding.ActivityLoginPickBinding

class LoginPickActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginPickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginPickBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}