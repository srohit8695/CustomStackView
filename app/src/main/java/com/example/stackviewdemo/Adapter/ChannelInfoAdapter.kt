package com.example.stackviewdemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.networklayer.resopnse.ProvidersInfo
import com.example.stackviewdemo.R
import com.example.stackviewdemo.databinding.ItemLayoutBinding

class ChannelInfoAdapter(var dateList: List<ProvidersInfo>, val context: Context) : RecyclerView.Adapter<ChannelInfoAdapter.DateViewHolder>(){

    inner class DateViewHolder(val binding : ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        with(holder){
            Glide.with(context)
                .load(dateList[position].logoPath)
                .error(R.drawable.default_channel)
                .into(binding.imageView);
        }
    }

    override fun getItemCount(): Int {
        return dateList.size
    }


}