package com.devatacreative.ayohealthy.activity.mainmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.devatacreative.ayohealthy.R
import com.devatacreative.ayohealthy.databinding.ActivityMainBinding
import com.devatacreative.ayohealthy.utils.SectionPagerAdapter
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var signInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getLoginData()
        initBottomLayout()
    }

    private fun getLoginData(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestProfile()
            .build()
        signInClient = GoogleSignIn.getClient(this, gso)
        val acc = GoogleSignIn.getLastSignedInAccount(this)
        if (acc != null){
            binding.email.text = acc.email
            binding.name.text = acc.displayName
        }
    }

    private fun initBottomLayout(){
        val pagerAdapter = SectionPagerAdapter(this)
        val viewPager: ViewPager2 = binding.viewPager2
        viewPager.adapter = pagerAdapter
        val bottomTab = binding.bottomNavigationView

        bottomTab.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    item.title = "Home"
                }
                else -> false
            }
            false
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}