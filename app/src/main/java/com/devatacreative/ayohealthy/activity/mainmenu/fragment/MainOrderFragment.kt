package com.devatacreative.ayohealthy.activity.mainmenu.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devatacreative.ayohealthy.R

/**
 * A simple [Fragment] subclass.
 * Use the [MainOrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainOrderFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_order, container, false)
    }

}