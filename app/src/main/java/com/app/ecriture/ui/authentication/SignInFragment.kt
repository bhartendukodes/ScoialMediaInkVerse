package com.app.ecriture.ui.authentication

import android.content.Intent
import android.util.Log
import androidx.navigation.fragment.findNavController
import com.app.ecriture.R
import com.app.ecriture.base.BaseFragment
import com.app.ecriture.databinding.FragmentSignInBinding
import com.app.ecriture.ui.activity.MainActivity
import com.app.ecriture.utils.extensions.click


class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {

    override fun initView() {
        onClick()
    }


    private fun onClick() {
        binding.apply {
            btnSignIn.click {
                startActivity(Intent(requireContext(), MainActivity::class.java))
            }
            tvSignUp.click {
                findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
            }
        }
    }


}