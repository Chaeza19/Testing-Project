package org.d3if3056.testing.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3056.testing.database.MahasiswaDao
import org.d3if3056.testing.ui.screen.MainViewModel

class ViewModelFactory(
    private val dao: MahasiswaDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}