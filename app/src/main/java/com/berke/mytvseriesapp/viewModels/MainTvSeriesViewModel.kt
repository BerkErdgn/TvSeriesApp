package com.berke.mytvseriesapp.viewModels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berke.mytvseriesapp.models.TvSeriesModels
import com.berke.mytvseriesapp.models.TvSeriesModelsItem
import com.berke.mytvseriesapp.service.forAPI.TvSeriesApiServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class MainTvSeriesViewModel :ViewModel(){
    private val disposable = CompositeDisposable()
    private val tvSeriesApiServices= TvSeriesApiServices()
    val tvSeriesList2 = MutableLiveData<TvSeriesModelsItem>()




    fun getDataForSecond(showId : Int){

        disposable.add(
            tvSeriesApiServices.getData2(showId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<TvSeriesModelsItem>(){
                    override fun onSuccess(t: TvSeriesModelsItem) {
                        tvSeriesList2.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })

        )



    }




   /* fun getDataForSecond( showId : Int) {
    launch {
       val tvSeriesApiServices = TvSeriesApiServices ()
       val deneme = tvSeriesApiServices.getData2(showId)
        deneme.map {
            tvSeriesLiveData.value=it
        }
    }

    }

    */

}




