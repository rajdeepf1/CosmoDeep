package com.example.cosmodeep.api
import com.example.cosmodeep.models.FeedModel
import com.example.cosmodeep.models.MarsModel
import com.example.cosmodeep.utils.Constant
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("/planetary/apod?api_key=${Constant.API_KEY}")
    suspend fun getFeeds(
        @Query("start_date") start_date: String,
        @Query("end_date") end_date: String
    ) : Response<FeedModel>

    @GET("/mars-photos/api/v1/rovers/curiosity/photos?sol=${Constant.SOL}&page=2&api_key=${Constant.API_KEY}")
    suspend fun getMarsImages() : Response<MarsModel>

}