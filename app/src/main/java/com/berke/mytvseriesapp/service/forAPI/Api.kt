package com.berke.mytvseriesapp.service.forAPI

import com.berke.mytvseriesapp.models.TvSeriesModels
import com.berke.mytvseriesapp.models.TvSeriesModelsItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


//https://api.tvmaze.com/
//shows

interface Api {
    @GET("shows")
    fun getTvSeries (): Single<TvSeriesModels>


    @GET ("shows/{showId}")
    fun getMainTvSeries  (@Path ("showId") showId: Int) : Single<TvSeriesModelsItem>

}