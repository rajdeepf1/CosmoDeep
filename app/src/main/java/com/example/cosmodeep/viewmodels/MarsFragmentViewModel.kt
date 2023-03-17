package com.example.cosmodeep.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cosmodeep.api.NetworkResult
import com.example.cosmodeep.models.FeedModel
import com.example.cosmodeep.models.MarsModel
import com.example.cosmodeep.repositories.MarsFragmentRepository
import com.example.cosmodeep.utils.Coroutines
import com.example.cosmodeep.utils.InternetConnectionCheck

class MarsFragmentViewModel(val marsFragmentRepository: MarsFragmentRepository): ViewModel() {
    var marsList: MutableLiveData<NetworkResult<MarsModel>> = MutableLiveData()

    fun getMarsImages(view: View) {
        if (InternetConnectionCheck.isOnline(view.context)) {
            Coroutines.main {
                marsList.value = NetworkResult.Loading()
                val data = marsFragmentRepository.getMarsImages()

                if (data.isSuccessful) {
                    marsList.value = NetworkResult.Success(data.body()!!)
                } else {
                    marsList.value = NetworkResult.Error(" Error Code : ${data.code()}")
                }
            }
        } else {
            NetworkResult.Error("Make sure you have connected to the network !", null)
        }
    }


}