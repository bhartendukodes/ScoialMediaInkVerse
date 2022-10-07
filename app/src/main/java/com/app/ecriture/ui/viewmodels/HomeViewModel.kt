package com.app.ecriture.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.ecriture.dummydata.DummyData
import com.app.ecriture.dummydata.Genere
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {

    val allListGenere = MutableLiveData<List<Genere>>()


    fun fruitsProductsDetails() {
        try {
            viewModelScope.launch {
                val listDish = DummyData.itemListUsingCurrentLocation
                allListGenere.postValue(listDish)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}