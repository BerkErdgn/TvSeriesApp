package com.berke.mytvseriesapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



data class Rating(

    @SerializedName("average")
    val average: Double
)