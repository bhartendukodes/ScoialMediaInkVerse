package com.app.ecriture.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import com.app.ecriture.R
import com.app.ecriture.base.BaseActivity
import com.app.ecriture.databinding.ActivitySplashBinding
import com.app.ecriture.ui.activity.ActivityAuthentication
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    override fun initView() {
        statusColor()
        navigate()
    }

    private fun statusColor() {
        WindowInsetsControllerCompat(this.window, this.window.decorView).isAppearanceLightStatusBars = true
        this.window.statusBarColor = ContextCompat.getColor(this, R.color.item_background)
    }


    private fun navigate() {
        lifecycleScope.launch{
            delay(4000)
            startActivity(Intent(this@SplashActivity, ActivityAuthentication::class.java))
            finishAffinity()
        }
    }

}