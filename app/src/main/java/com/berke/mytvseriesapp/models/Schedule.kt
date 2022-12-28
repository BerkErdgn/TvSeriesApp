package com.berke.mytvseriesapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



data class Schedule(
    @SerializedName("days")
    val days: List<String>,

    @SerializedName("time")
    val time: String
)