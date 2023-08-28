package com.app.ecriture

import android.opengl.Visibility
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.ecriture.base.BaseFragment
import com.app.ecriture.databinding.FragmentProfileBinding
import com.app.ecriture.ui.adapters.ProfileAdapter
import com.app.ecriture.ui.adapters.SearchAdapter
import com.app.ecriture.ui.viewmodels.HomePageViewModel
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    private val profileAdapter by lazy {
        ProfileAdapter()
    }

    private val searchViewModel by lazy {
        ViewModelProvider(this)[HomePageViewModel::class.java]
    }

    override fun initView() {
        observer()
        setData()
        onClick()
    }

    private fun onClick() {
        binding.apply {
            titleNotification.tvTitle.text = "Katty Julinea"
        }
    }

    private fun observer() {
        searchViewModel.searchData.observe(viewLifecycleOwner){
            profileAdapter.submitList(it)
        }
    }

    private fun setData() {
        binding.apply {
            searchViewModel.searchPostedList()
            rvProfile.layoutManager= StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            rvProfile.adapter= profileAdapter
        }
    }


}