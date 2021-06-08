package com.devatacreative.ayohealthy.activity.mainmenu.accountmenu

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.devatacreative.ayohealthy.activity.ChangeAccountDataActivity
import com.devatacreative.ayohealthy.data.profilemenu.ProfileMenuObject
import com.devatacreative.ayohealthy.databinding.ProfileMenuItemBinding
import com.devatacreative.ayohealthy.model.MenuModel

class AccountMenuAdapter: RecyclerView.Adapter<AccountMenuAdapter.AccountMenuViewHolder>() {
    val menu = ProfileMenuObject.profileMenu

    inner class AccountMenuViewHolder(private val itemBinding: ProfileMenuItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(menuItem: MenuModel){
            itemBinding.profileMenuText.text = menuItem.item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountMenuViewHolder {
        val itemBinding = ProfileMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountMenuViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AccountMenuViewHolder, position: Int) {
        val data = menu[position]
        holder.bind(data)
        holder.itemView.setOnClickListener {
            when(data.id){
                0 ->{
                    val intent = Intent(holder.itemView.context, ChangeAccountDataActivity::class.java)
                    holder.itemView.context.startActivity(intent)
                }
                else -> {
                    val context = holder.itemView.context
                    Toast.makeText(context, "No id", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int = this.menu.size
}