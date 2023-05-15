package com.luiz.tmdbclient.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luiz.tmdbclient.R
import com.luiz.tmdbclient.data.model.tvshow.TvShow
import com.luiz.tmdbclient.databinding.ListItemBinding

class TvShowAdapter: RecyclerView.Adapter<TvShowViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()

    fun setList(listTvShow: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(listTvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return TvShowViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }
}

class TvShowViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TvShow){
        binding.tvTitle.text = tvShow.name
        binding.tvDescription.text = tvShow.overview

        val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imgContent.context)
            .load(posterURL)
            .into(binding.imgContent)
    }
}