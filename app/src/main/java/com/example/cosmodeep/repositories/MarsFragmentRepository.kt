package com.example.cosmodeep.repositories

import com.example.cosmodeep.api.ApiService
import com.example.cosmodeep.api.RetrofitInstance
import com.example.cosmodeep.models.MarsModel
import retrofit2.Response

class MarsFragmentRepository(private val api: Class<ApiService>) {
    private val TAG: String? = "MarsFragmentRepository"

    suspend fun getMarsImages(): Response<MarsModel> {
        val call = RetrofitInstance.buildService(api).getMarsImages()
        return call
    }

}