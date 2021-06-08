package com.devatacreative.ayohealthy.activity.mainmenu.accountmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.devatacreative.ayohealthy.R
import com.devatacreative.ayohealthy.databinding.FragmentAccountBinding
import com.devatacreative.ayohealthy.model.UserPrefModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment(private val userProfile: UserPrefModel) : Fragment() {

    private lateinit var binding: FragmentAccountBinding
    private lateinit var signInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentAccountBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountBinding.inflate(layoutInflater, container, false)
        setProfileData()
        setRecyclerView()
        setSignOut()
        return binding.root
    }

    private fun setRecyclerView(){
        val recyclerView = binding.recyclerView
        val adapter = AccountMenuAdapter(this.requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
    }

    private fun setSignOut(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestProfile()
            .build()


    }

    private fun setProfileData(){
        binding.profileName.text = userProfile.name
        context?.let {
            Glide.with(it)
                .load(userProfile.avatarUrl)
                .error(R.drawable.blank_profile)
                .into(binding.profileImage)
        }
    }


}