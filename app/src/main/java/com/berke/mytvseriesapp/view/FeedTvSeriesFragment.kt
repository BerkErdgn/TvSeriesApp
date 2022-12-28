package com.berke.mytvseriesapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.berke.mytvseriesapp.R
import com.berke.mytvseriesapp.adapter.TvSeriesAdapter
import com.berke.mytvseriesapp.models.TvSeriesModels
import com.berke.mytvseriesapp.viewModels.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed_tv_series.*

private lateinit var viewModel: FeedViewModel
private var tvSeriesAdapter = TvSeriesAdapter (TvSeriesModels())

class FeedTvSeriesFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed_tv_series, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.refreshData()

        feedRecyclerView.layoutManager=GridLayoutManager(context,2)
        feedRecyclerView.adapter= tvSeriesAdapter

        observeLiveData()

    }


    private fun observeLiveData (){
        viewModel.tvSeriesList.observe(viewLifecycleOwner, Observer { TvSeriesModels->
            TvSeriesModels?.let{
                feedRecyclerView.visibility=View.VISIBLE
                tvSeriesAdapter.updateTvSeriesList(TvSeriesModels)
            }

        })
    }
}

