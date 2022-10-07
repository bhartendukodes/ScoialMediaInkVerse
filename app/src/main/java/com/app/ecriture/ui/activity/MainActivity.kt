package com.app.ecriture.ui.activity

import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.app.ecriture.R
import com.app.ecriture.base.BaseActivity
import com.app.ecriture.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private var navController: NavController? = null


    override fun initView() {
        statusColor()
        setUpNavigation()
        setViews()
    }

    private fun setViews() {
       navController?.addOnDestinationChangedListener{_, destination, _ ->
           when(destination.id){
               R.id.homeFragment->{

               }
               R.id.searchFragment->{

               }
               R.id.postFragment->{

               }
               R.id.notificationFragment->{

               }
               R.id.profileFragment->{

               }
           }

       }
    }

    private fun statusColor() {
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        window?.statusBarColor = ContextCompat.getColor(this, R.color.white)
    }

    private fun setUpNavigation() {
        navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)
            ?.findNavController()

        navController?.let {
            binding.apply {
                btmNav.setupWithNavController(it)
            }
        }

    }



}