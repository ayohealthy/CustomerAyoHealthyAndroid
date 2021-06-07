package com.devatacreative.ayohealthy.activity.mainmenu.fragment

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.devatacreative.ayohealthy.R
import com.devatacreative.ayohealthy.activity.adapter.HomeMenuAdapter
import com.devatacreative.ayohealthy.databinding.FragmentMainBinding
import com.devatacreative.ayohealthy.model.UserPrefModel

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment(private val userProfile: UserPrefModel) : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setRecyclerView()
        setViewData()
        return binding.root
    }

    private fun setViewData(){
        binding.userDisplayName.text = userProfile.name
        Log.e("Profile URL : ", userProfile.avatarUrl.toString())
        if (userProfile.avatarUrl != null){
            context?.let {
                Glide.with(it)
                    .load(userProfile.avatarUrl)
                    .error(R.drawable.blank_profile)
                    .into(binding.homeProfileImage)
            }
        }
    }

    private fun setRecyclerView(){
        val recyclerView = binding.productRecyclerView
        val adapter = HomeMenuAdapter()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this.context, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}