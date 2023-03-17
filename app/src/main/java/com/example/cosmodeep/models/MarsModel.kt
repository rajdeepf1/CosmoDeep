package com.example.cosmodeep.models


import com.google.gson.annotations.SerializedName

data class MarsModel(
    @SerializedName("photos")
    val photos: List<Photo>
)