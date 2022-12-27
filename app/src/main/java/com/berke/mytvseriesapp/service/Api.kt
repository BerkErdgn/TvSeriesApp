package com.berke.mytvseriesapp.service

import com.berke.mytvseriesapp.models.TvSeriesModels
import com.berke.mytvseriesapp.models.TvSeriesModelsItem
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET


//https://api.tvmaze.com/
//shows

interface Api {
    @GET("shows")
    fun getTvSeries (): Single<TvSeriesModels>
}