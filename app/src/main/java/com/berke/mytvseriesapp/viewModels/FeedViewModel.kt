package com.berke.mytvseriesapp.viewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berke.mytvseriesapp.models.TvSeriesModels
import com.berke.mytvseriesapp.service.TvSeriesApiServices
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel(){
    private val disposable = CompositeDisposable()
    private val tvSeriesApiServices= TvSeriesApiServices()
    val tvSeriesList = MutableLiveData<TvSeriesModels>()

    fun refreshData(){
        getDataFromAPI()
    }

    private fun getDataFromAPI(){

        disposable.add(
            tvSeriesApiServices.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<TvSeriesModels>(){
                    override fun onSuccess(t: TvSeriesModels) {
                        tvSeriesList.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })

        )



    }



}