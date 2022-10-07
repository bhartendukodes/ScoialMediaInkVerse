package com.app.ecriture.ui.authentication

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.app.ecriture.base.BaseFragment
import com.app.ecriture.databinding.FragmentSelectCategorieBinding
import com.app.ecriture.ui.activity.MainActivity
import com.app.ecriture.ui.adapters.GenereAdapter
import com.app.ecriture.ui.viewmodels.HomeViewModel
import com.app.ecriture.utils.extensions.click
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent


class SelectCategorieFragment :
    BaseFragment<FragmentSelectCategorieBinding>(FragmentSelectCategorieBinding::inflate) {

    private val genereViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private val genereAdapter by lazy {
        GenereAdapter { allowToProceed ->
            binding.btProceed.isEnabled=allowToProceed
            binding.btProceed.alpha = if(allowToProceed) 1f else 0.4f
        }
    }

    override fun initView() {
        observer()
        setViews()
        onClick()
    }

    private fun observer() {
        genereViewModel.allListGenere.observe(viewLifecycleOwner) {
            genereAdapter.submitList(it)
        }
    }

    private fun setViews() {
        genereViewModel.fruitsProductsDetails()

        val layoutManager = FlexboxLayoutManager(requireContext())
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.FLEX_START
        binding.apply {
            rvViews.layoutManager = layoutManager
            rvViews.adapter = genereAdapter
        }

    }
    private fun onClick() {
        binding.apply {
            btProceed.click {
                startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
    }


}