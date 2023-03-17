package com.example.cosmodeep.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cosmodeep.repositories.HomeRepository
import com.example.cosmodeep.repositories.MarsFragmentRepository
import com.example.cosmodeep.viewmodels.HomeFragmentViewModel
import com.example.cosmodeep.viewmodels.MarsFragmentViewModel

class MarsFragmentFactory(private val marsFragmentRepository: MarsFragmentRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MarsFragmentViewModel(marsFragmentRepository) as T
    }
}