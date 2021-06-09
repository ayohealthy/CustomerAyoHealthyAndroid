package com.devatacreative.ayohealthy.activity.adapter

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devatacreative.ayohealthy.R
import com.devatacreative.ayohealthy.databinding.ProductItemBinding
import com.devatacreative.ayohealthy.model.RecommendedFnbItem

class HomeMenuAdapter: RecyclerView.Adapter<HomeMenuAdapter.HomeViewHolder>() {
    private var menus = ArrayList<RecommendedFnbItem>()
    inner class HomeViewHolder(private val itemBinding: ProductItemBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(items: RecommendedFnbItem){
            Glide.with(itemView.context)
                .load(items.imageUrl)
                .error(R.drawable.login_bg)
                .into(itemBinding.itemFoodImage)
            itemBinding.itemMenuName.text = items.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemBinding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
//        if (position%2==0){
//            val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
//            params.gravity = Gravity.RIGHT
//
//        }
        val data = menus[position]
        holder.bind(data)
    }

    fun setData(items: List<RecommendedFnbItem>){
        menus.clear()
        menus.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int  = menus.size
}