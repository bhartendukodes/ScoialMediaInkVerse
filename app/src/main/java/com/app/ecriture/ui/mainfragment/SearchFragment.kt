package com.app.ecriture.ui.mainfragment

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.ecriture.base.BaseFragment
import com.app.ecriture.databinding.FragmentSearchBinding
import com.app.ecriture.ui.adapters.SearchAdapter
import com.app.ecriture.ui.viewmodels.HomePageViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    private val searchAdapter by lazy {
        SearchAdapter()
    }

    private val searchViewModel by lazy {
        ViewModelProvider(this)[HomePageViewModel::class.java]
    }

    override fun initView() {
        observer()
        setData()
    }

    private fun observer() {
        searchViewModel.searchData.observe(viewLifecycleOwner){
            searchAdapter.submitList(it)
        }
    }

    private fun setData() {
        binding.apply {
            searchViewModel.searchPostedList()
            rvSearch.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            rvSearch.adapter= searchAdapter
        }
    }

}