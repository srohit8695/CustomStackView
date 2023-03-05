package com.example.stackviewdemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.stackviewdemo.R
import com.example.stackviewdemo.databinding.ItemLayoutBinding

class StackedCardsAdapter(
    private val context: Context,
    private val data: List<String>,
) : BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): String {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?,
    ): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        view.also {
//                it.findViewById<TextView>(R.id.text_view).text = data[position]
            it.findViewById<ImageView>(R.id.image_view).setImageResource(nameList[position%7])

        }



        return view
    }

    var nameList = intArrayOf(
        R.drawable.blue1,
        R.drawable.brown1,
        R.drawable.white1,
        R.drawable.gray1,
        R.drawable.darkblue1,
        R.drawable.red1,
        R.drawable.green1
    )

}