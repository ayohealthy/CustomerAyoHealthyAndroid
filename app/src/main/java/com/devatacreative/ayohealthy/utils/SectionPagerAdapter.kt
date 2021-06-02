package com.devatacreative.ayohealthy.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.devatacreative.ayohealthy.activity.mainmenu.fragment.HomeFragment

class SectionPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> {
                fragment = HomeFragment()

            }
        }
        return fragment as Fragment
    }
}