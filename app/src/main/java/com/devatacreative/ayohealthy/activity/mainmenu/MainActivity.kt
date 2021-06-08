package com.devatacreative.ayohealthy.activity.mainmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.devatacreative.ayohealthy.R
import com.devatacreative.ayohealthy.activity.mainmenu.accountmenu.AccountFragment
import com.devatacreative.ayohealthy.activity.mainmenu.fragment.MainFragment
import com.devatacreative.ayohealthy.activity.mainmenu.fragment.MainOrderFragment
import com.devatacreative.ayohealthy.databinding.ActivityMainBinding
import com.devatacreative.ayohealthy.model.UserPrefModel
import com.devatacreative.ayohealthy.utils.UserPref
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var signInClient: GoogleSignInClient
    private lateinit var userProfile: UserPrefModel
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
        userProfile = UserPref(this).getUser()

    }

    private fun initBottomLayout(){
        val bottomTab = binding.bottomNavigationView
        bottomTab.itemIconTintList = null
        getFragmentPage(MainFragment(userProfile))
        bottomTab.setOnNavigationItemSelectedListener { item ->
            val fragment: Fragment?
            when (item.itemId) {
                R.id.menu_home -> {
                    fragment = MainFragment(userProfile)
                    getFragmentPage(fragment)

                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_order -> {
                    getFragmentPage(MainOrderFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_profile -> {
                    fragment = AccountFragment(userProfile)
                    getFragmentPage(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            true
        }
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