package com.devatacreative.ayohealthy.activity.mainmenu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.devatacreative.ayohealthy.activity.adapter.HomeMenuAdapter
import com.devatacreative.ayohealthy.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
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
        return binding.root
    }

    private fun setRecyclerView(){
        val recyclerView = binding.productRecyclerView
        val adapter = HomeMenuAdapter()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this.context, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

    }

}