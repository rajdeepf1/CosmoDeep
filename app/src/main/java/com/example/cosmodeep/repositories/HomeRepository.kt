package com.example.cosmodeep.repositories

import android.util.Log
import com.example.cosmodeep.api.ApiService
import com.example.cosmodeep.api.RetrofitInstance
import com.example.cosmodeep.models.FeedModel
import retrofit2.Response

class HomeRepository(private val api: Class<ApiService>) {

    private val TAG: String? = "HomeRepository"

    suspend fun getFeeds(start_date: String,end_date:String): Response<FeedModel> {
        val call = RetrofitInstance.buildService(api).getFeeds(start_date = start_date, end_date = end_date)
        return call
    }

}