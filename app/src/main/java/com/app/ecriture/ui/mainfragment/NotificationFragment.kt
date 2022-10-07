package com.app.ecriture.ui.mainfragment

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.ecriture.R
import com.app.ecriture.base.BaseFragment
import com.app.ecriture.databinding.FragmentNotificationBinding
import com.app.ecriture.ui.adapters.NotificationAdapter
import com.app.ecriture.ui.viewmodels.HomePageViewModel

class NotificationFragment : BaseFragment<FragmentNotificationBinding>(FragmentNotificationBinding::inflate) {

    private val notificationAdapter by lazy {
        NotificationAdapter()
    }

    private val notificationViewModel by lazy {
        ViewModelProvider(this)[HomePageViewModel::class.java]
    }

    override fun initView() {
        observer()
        setViews()
        initialization()
    }

    private fun setViews() {
        binding.apply {
            titleNotification.tvTitle.text = getText(R.string.notification)
        }
    }

    private fun initialization() {
        binding.apply {
            notificationViewModel.notificationData()
            rvListOfComments.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvListOfComments.adapter=notificationAdapter
        }
    }

    private fun observer() {
        notificationViewModel.notificationData.observe(viewLifecycleOwner){
            notificationAdapter.submitList(it)
        }
    }
}