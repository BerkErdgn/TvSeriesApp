package com.berke.mytvseriesapp.service.forAPI

import com.berke.mytvseriesapp.models.TvSeriesModels
import com.berke.mytvseriesapp.models.TvSeriesModelsItem
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


//https://api.tvmaze.com/
//shows

class TvSeriesApiServices {
    private var BASE_URL = "https://api.tvmaze.com/"
    private var api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(Api::class.java)


    fun getData (): Single<TvSeriesModels>{
        return api.getTvSeries()
    }

    fun getData2 ( showId : Int): Single<TvSeriesModelsItem>{
        return  api.getMainTvSeries(showId)
    }


}