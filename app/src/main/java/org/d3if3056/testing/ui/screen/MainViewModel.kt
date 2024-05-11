package org.d3if3056.testing.ui.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3056.testing.model.Hewan
import org.d3if3056.testing.network.HewanApi

class MainViewModel : ViewModel() {
    var data = mutableStateOf(emptyList<Hewan>())
        private set

    init {
        retrieveData()
    }

    private fun retrieveData(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                data.value = HewanApi.service.getHewan()
            } catch (e: Exception){
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }
}