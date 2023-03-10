package com.example.stackviewdemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.networklayer.resopnse.DataResponse
import com.example.stackviewdemo.databinding.ItemStackviewPackageInfoBinding

class StckedViewPackageInfoAdapter(
    private val context: Context,
    private val data: List<DataResponse>
) : BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): DataResponse {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        /*val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_stackview_package_info, parent, false)
        view.also {
            it.findViewById<AppCompatTextView>(R.id.packageInfoName).text = data[position].packageName.toString()
            it.findViewById<AppCompatTextView>(R.id.numberOfProviders).text = data[position].providersInfo.size.toString()+" Providers"
            val iconRecyclerView = it.findViewById<RecyclerView>(R.id.channelIcons)
            iconRecyclerView.adapter = ChannelInfoAdapter(data[position].providersInfo,context)
        }*/

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemStackviewPackageInfoBinding.inflate(layoutInflater, parent, false)
        binding.packageInfoName.text = data[position].packageName.toString()
        binding.numberOfProviders.text = data[position].providersInfo.size.toString()+" Providers"
        binding.channelIcons.adapter = ChannelInfoAdapter(data[position].providersInfo,context)

        return binding.root
    }


}