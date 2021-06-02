package com.devatacreative.ayohealthy.activity.adapter

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.devatacreative.ayohealthy.databinding.ProductItemBinding

class HomeMenuAdapter: RecyclerView.Adapter<HomeMenuAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(private val itemBinding: ProductItemBinding): RecyclerView.ViewHolder(itemBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemBinding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        if (position%2==0){
            val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
            params.gravity = Gravity.RIGHT

        }

    }

    override fun getItemCount(): Int  = 10
}