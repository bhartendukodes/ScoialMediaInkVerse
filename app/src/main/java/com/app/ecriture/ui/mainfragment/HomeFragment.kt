package com.app.ecriture.ui.mainfragment

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.ecriture.base.BaseFragment
import com.app.ecriture.databinding.FragmentHomeBinding
import com.app.ecriture.ui.adapters.FeedAdapter
import com.app.ecriture.ui.viewmodels.HomePageViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val homeViewModel by lazy {
        ViewModelProvider(this)[HomePageViewModel::class.java]
    }

    private val feedAdapter by lazy {
        FeedAdapter()
    }

    override fun initView() {
        observer()
        setViews()
    }

    private fun observer() {
        homeViewModel.postedData.observe(viewLifecycleOwner) {
            feedAdapter.submitList(it)
        }
    }

    private fun setViews() {
        binding.apply {
            homeViewModel.postedList()
            rvListOfPost.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            rvListOfPost.adapter=feedAdapter
        }
    }
}