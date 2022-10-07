package com.app.ecriture.ui.authentication

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.app.ecriture.base.BaseFragment
import com.app.ecriture.databinding.FragmentOnBoardingScreenBinding
import com.app.ecriture.ui.adapters.BannerAdapter
import com.app.ecriture.ui.viewmodels.HomePageViewModel
import com.app.ecriture.utils.extensions.click
import com.google.android.material.tabs.TabLayoutMediator


class OnBoardingFragment :
    BaseFragment<FragmentOnBoardingScreenBinding>(FragmentOnBoardingScreenBinding::inflate) {

    private val bannerAdapter by lazy {
        BannerAdapter()
    }

    private val bannerViewModel by lazy {
        ViewModelProvider(this)[HomePageViewModel::class.java]
    }

    override fun initView() {
        observer()
        setViews()
        onClick()
    }

    private fun onClick() {
        binding.apply {
            btnGetStarted.click {
                findNavController().navigate(
                    OnBoardingFragmentDirections.actionOnBoardingScreenToSignInFragment()
                )
            }
        }
    }

    private fun observer() {
        bannerViewModel.bannerData.observe(viewLifecycleOwner)
        {
            binding.apply {
                bannerAdapter.submitList(it)
                vpBanner.adapter = bannerAdapter
                TabLayoutMediator(
                    binding.tabBanner,
                    binding.vpBanner
                ) { _position, _tab -> }.attach()
            }
        }
    }

    private fun setViews() {
        bannerViewModel.bannerList()
    }


}