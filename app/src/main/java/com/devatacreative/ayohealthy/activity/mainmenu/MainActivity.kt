package com.devatacreative.ayohealthy.activity.mainmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.devatacreative.ayohealthy.R
import com.devatacreative.ayohealthy.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView


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
//        val pagerAdapter = SectionPagerAdapter(this)
//        viewPager.adapter = pagerAdapter
//        val bottomTab = binding.bottomNavigationView
//        bottomTab.itemIconTintList = null
//        bottomTab.setOnNavigationItemSelectedListener { item ->
//            val fragment: Fragment?
//            when (item.itemId) {
//                R.id.menu_home -> {
//                    item.title = "Home"
//                    item.setIcon(R.drawable.home_active)
//                    fragment = MainFragment()
//                    getFragmentPage(fragment)
////                    viewPager.currentItem = 0
//
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.menu_order -> {
//                    item.setIcon(R.drawable.order_active)
//                    getFragmentPage(MainOrderFragment())
////                    viewPager.currentItem = 1
//                }
//                R.id.menu_profile -> {
//                    item.setIcon(R.drawable.account_active)
//                    fragment = AccountFragment()
//                    getFragmentPage(fragment)
////                    viewPager.currentItem = 2
//                    return@setOnNavigationItemSelectedListener true
//                }
//            }
//            false
//        }
        val navView: BottomNavigationView = binding.bottomNavigationView

        val navController = findNavController(R.id.viewPager2)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.mainOrderFragment, R.id.accountFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun getFragmentPage(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.viewPager2, fragment)
                .commit()
            return true
        }
        return false
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}