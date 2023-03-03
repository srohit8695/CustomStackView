package com.example.stackviewdemo


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.stackviewdemo.databinding.ItemLayoutBinding


class MainAdapter internal constructor(context: Context, private val nameList: IntArray) :
    BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return nameList.size
    }

    override fun getItem(position: Int): Any {
        return nameList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var convertView = view
        val holder: ViewHolder
        if (convertView == null) {
            val binding = ItemLayoutBinding.inflate(inflater)
            convertView = binding.root
            holder = ViewHolder()
            holder.imageView = binding.imageView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.imageView!!.setBackgroundResource(nameList[position])
        return convertView
    }

    inner class ViewHolder {
        internal var imageView: ImageView? = null
    }
}

