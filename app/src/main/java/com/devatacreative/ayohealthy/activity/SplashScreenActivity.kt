package com.devatacreative.ayohealthy.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.devatacreative.ayohealthy.activity.auth.LoginActivity
import com.devatacreative.ayohealthy.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        Handler(mainLooper).postDelayed({
            intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(intent)
        }, 2500)
    }
}