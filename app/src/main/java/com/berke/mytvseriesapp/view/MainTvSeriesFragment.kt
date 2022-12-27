package com.berke.mytvseriesapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.berke.mytvseriesapp.R
import com.berke.mytvseriesapp.models.TvSeriesModels
import com.berke.mytvseriesapp.viewModels.FeedViewModel
import kotlinx.android.synthetic.main.fragment_main_tv_series.*


class MainTvSeriesFragment : Fragment() {
    private lateinit var viewModel: FeedViewModel
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

        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.refreshData()


        observeLivveData()
    }

    private fun observeLivveData (){
        viewModel.tvSeriesList.observe(viewLifecycleOwner, Observer { TvSeriesModels->
            TvSeriesModels?.let {
                it.map {
                    nameText.text=it.id.toString()

                }

            }

        })
    }


}