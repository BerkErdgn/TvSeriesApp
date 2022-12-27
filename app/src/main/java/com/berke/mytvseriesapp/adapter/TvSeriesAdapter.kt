package com.berke.mytvseriesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.berke.mytvseriesapp.R
import com.berke.mytvseriesapp.helper.downloadFromUrl
import com.berke.mytvseriesapp.helper.placeHolderProgressBar
import com.berke.mytvseriesapp.models.TvSeriesModels
import com.berke.mytvseriesapp.view.FeedTvSeriesFragmentDirections
import io.reactivex.Single

import kotlinx.android.synthetic.main.tvseries.view.*

class TvSeriesAdapter( val tvSeriesList : TvSeriesModels): RecyclerView.Adapter<TvSeriesAdapter.TvSeriesViewHolder>() {

    class TvSeriesViewHolder (var view:View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvSeriesViewHolder {
       val inflater = LayoutInflater.from(parent.context)
       val view = inflater.inflate(R.layout.tvseries,parent,false)
       return TvSeriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvSeriesViewHolder, position: Int) {
        holder.view.feedTvSeriesNameText.text= tvSeriesList[position].name
        holder.view.feedImage.downloadFromUrl(tvSeriesList[position].image.medium, placeHolderProgressBar(holder.view.context))


        //for viewClick
        holder.view.setOnClickListener{
            val action = FeedTvSeriesFragmentDirections.actionFeedTvSeriesFragmentToMainTvSeriesFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
       return tvSeriesList.size
    }


    fun updateTvSeriesList (newTvSeriesList: TvSeriesModels){
        tvSeriesList.clear()
        tvSeriesList.addAll(newTvSeriesList)
            notifyDataSetChanged()
    }

}