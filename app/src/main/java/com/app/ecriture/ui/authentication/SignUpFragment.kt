package com.app.ecriture.ui.authentication

import androidx.navigation.fragment.findNavController
import com.app.ecriture.base.BaseFragment
import com.app.ecriture.databinding.FragmentSignInBinding
import com.app.ecriture.databinding.FragmentSignUpBinding
import com.app.ecriture.utils.extensions.click


class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate){

    override fun initView() {
        onClick()
    }

    private fun onClick() {
        binding.apply {
            tvSignIn.click {
                findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
            }
            tvSignUp.click {
                findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToPenNameFragment())
            }
        }
    }


}