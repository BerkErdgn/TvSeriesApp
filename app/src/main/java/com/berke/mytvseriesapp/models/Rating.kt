package com.berke.mytvseriesapp.models

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    val average: Double
)