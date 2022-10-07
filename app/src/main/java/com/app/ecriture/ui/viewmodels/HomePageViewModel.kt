package com.app.ecriture.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.ecriture.dummydata.*
import kotlinx.coroutines.launch

class HomePageViewModel() : ViewModel() {

    val postedData = MutableLiveData<List<Genere.WriteUpPage>>()
    val searchData = MutableLiveData<List<SearchList>>()
    val bannerData = MutableLiveData<List<Banner>>()
    val notificationData = MutableLiveData<List<NotificationData>>()

    fun postedList(){
        try {
            viewModelScope.launch {
                val postedList = DummyData.postedData
                postedData.postValue(postedList)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun searchPostedList(){
        try {
            viewModelScope.launch {
                val searchList = DummyData.postedSearch
                searchData.postValue(searchList)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun bannerList(){
        try {
            viewModelScope.launch {
                val bannerAds = DummyData.bannerData
                bannerData.postValue(bannerAds)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun notificationData(){
        try {
            viewModelScope.launch {
                val notifyData = DummyData.notificationData
                notificationData.postValue(notifyData)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}