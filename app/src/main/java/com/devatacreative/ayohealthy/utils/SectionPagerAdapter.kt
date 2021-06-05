package com.devatacreative.ayohealthy.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devatacreative.ayohealthy.activity.mainmenu.fragment.AccountFragment
import com.devatacreative.ayohealthy.activity.mainmenu.fragment.MainFragment
import com.devatacreative.ayohealthy.activity.mainmenu.fragment.MainOrderFragment

class SectionPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> {
                fragment = MainFragment()
            }
            1 -> {
                fragment = MainOrderFragment()
            }
            2 -> {
                fragment = AccountFragment()
            }
        }
        return fragment as Fragment
    }
}