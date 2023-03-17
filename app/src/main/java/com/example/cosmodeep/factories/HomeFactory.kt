package com.example.cosmodeep.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cosmodeep.repositories.HomeRepository
import com.example.cosmodeep.viewmodels.HomeFragmentViewModel

class HomeFactory(private val homeRepository: HomeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeFragmentViewModel(homeRepository) as T
    }
}