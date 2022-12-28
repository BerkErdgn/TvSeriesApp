package com.berke.mytvseriesapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.berke.mytvseriesapp.R
import com.berke.mytvseriesapp.helper.downloadFromUrl
import com.berke.mytvseriesapp.helper.placeHolderProgressBar
import com.berke.mytvseriesapp.models.TvSeriesModels
import com.berke.mytvseriesapp.models.TvSeriesModelsItem
import com.berke.mytvseriesapp.viewModels.FeedViewModel
import com.berke.mytvseriesapp.viewModels.MainTvSeriesViewModel
import kotlinx.android.synthetic.main.fragment_main_tv_series.*


class MainTvSeriesFragment : Fragment() {
    private lateinit var viewModel: MainTvSeriesViewModel
    private var tvSeriesid =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_tv_series, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        arguments?.let {
            tvSeriesid = FeedTvSeriesFragmentArgs.fromBundle(it).tvShowid
        }

        viewModel = ViewModelProviders.of(this).get(MainTvSeriesViewModel::class.java)
        viewModel.getDataForSecond(showId= tvSeriesid)

        println(tvSeriesid)


        viewModel.tvSeriesList2.observe(viewLifecycleOwner, Observer { TvSeriesModels->
            TvSeriesModels?.let {

                    nameText.text=it.name
                    typrText.text=it.type
                    languageText.text=it.language
                    runtimeText.text=it.runtime.toString()
                    summaryText.text=it.summary
                    ratingText.text=it.rating.average.toString()
                    schedduleText.text=it.schedule.days.toString()
                    context?.let {

                        imageView.downloadFromUrl(TvSeriesModels.image.original,
                            placeHolderProgressBar(it)
                        )
                    }



            }

        })
       // observeLivveData()

    }

    private fun observeLivveData (){

    }


}