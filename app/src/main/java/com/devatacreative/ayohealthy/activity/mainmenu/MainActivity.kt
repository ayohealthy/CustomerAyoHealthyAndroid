package com.devatacreative.ayohealthy.activity.mainmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.devatacreative.ayohealthy.R
import com.devatacreative.ayohealthy.activity.mainmenu.fragment.AccountFragment
import com.devatacreative.ayohealthy.activity.mainmenu.fragment.MainFragment
import com.devatacreative.ayohealthy.activity.mainmenu.fragment.MainOrderFragment
import com.devatacreative.ayohealthy.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


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
//            binding.email.text = acc.email
//            binding.name.text = acc.displayName
        }
    }

    private fun initBottomLayout(){
//        val pagerAdapter = SectionPagerAdapter(this)
//        viewPager.adapter = pagerAdapter

        val bottomTab = binding.bottomNavigationView
        bottomTab.itemIconTintList = null
        getFragmentPage(MainFragment())
//        val navController = findNavController(R.id.nav_fragment)
//        bottomTab.setupWithNavController(navController)

        bottomTab.setOnNavigationItemSelectedListener { item ->
            val fragment: Fragment?
            when (item.itemId) {
                R.id.menu_home -> {
                    fragment = MainFragment()
                    getFragmentPage(fragment)

                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_order -> {
                    getFragmentPage(MainOrderFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_profile -> {
                    fragment = AccountFragment()
                    getFragmentPage(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            true
        }
//        val navView: BottomNavigationView = binding.bottomNavigationView
//
//        val navController = findNavController(R.id.viewPager2)
//
//        navView.setupWithNavController(navController)
    }

    private fun getFragmentPage(fragment: Fragment?) {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_fragment, fragment, fragment.javaClass.simpleName)
                .commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}