package com.app.ecriture.ui.activity

import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.app.ecriture.R
import com.app.ecriture.base.BaseActivity
import com.app.ecriture.databinding.ActivityAuthenticationBinding

class ActivityAuthentication :
    BaseActivity<ActivityAuthenticationBinding>(ActivityAuthenticationBinding::inflate) {
    override fun initView() {
        statusColor()
    }

    private fun statusColor() {
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        window?.statusBarColor = ContextCompat.getColor(this, R.color.white)
    }
}