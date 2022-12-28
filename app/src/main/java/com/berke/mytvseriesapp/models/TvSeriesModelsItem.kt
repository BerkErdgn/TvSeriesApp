package com.berke.mytvseriesapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class TvSeriesModelsItem(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("language")
    val language: String,

    @SerializedName("genres")
    val genres: List<String>,

    @SerializedName("runtime")
    val runtime: Int,

    @SerializedName("schedule")
    val schedule: Schedule,

    @SerializedName("rating")
    val rating: Rating,

    @SerializedName("image")
    val image: Image,

    @SerializedName("summary")
    val summary: String)