package com.app.ecriture.ui.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.ecriture.R
import com.app.ecriture.base.BaseFragment
import com.app.ecriture.databinding.FragmentPenNameBinding
import com.app.ecriture.utils.extensions.click
import com.app.ecriture.utils.extensions.gone

class PenNameFragment : BaseFragment<FragmentPenNameBinding>(FragmentPenNameBinding::inflate) {


    override fun initView() {
        onClick()
    }

    private fun onClick() {
        binding.apply{
            btnProceed.click {
                findNavController().navigate(PenNameFragmentDirections.actionPenNameFragmentToSelectCategorie())
            }
            ivSucessImg.gone()
        }
    }
}