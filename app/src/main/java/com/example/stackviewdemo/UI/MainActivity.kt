package com.example.stackviewdemo.UI

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.customstackview.OnChangeListener
import com.example.stackviewdemo.R
import com.example.stackviewdemo.ViewModel.PackageInfoViewModel
import com.example.stackviewdemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var packageInfoViewModel : PackageInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        packageInfoViewModel = ViewModelProvider(this)[PackageInfoViewModel::class.java]
        val tempData = packageInfoViewModel.getAllPackageInfo()

        try {
            tempData.observe(this, Observer{

                    val data = it.data?.statusCode
                    Toast.makeText(this,data.toString(),Toast.LENGTH_SHORT).show()

            })
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val data = listOf(
            "${getString(R.string.app_name)} 1",
            "${getString(R.string.app_name)} 2",
            "${getString(R.string.app_name)} 3",
            "${getString(R.string.app_name)} 4",
            "${getString(R.string.app_name)} 5",
            "${getString(R.string.app_name)} 6",
            "${getString(R.string.app_name)} 7",
            "${getString(R.string.app_name)} 8",
            "${getString(R.string.app_name)} 9",
            "${getString(R.string.app_name)} 10",
            "${getString(R.string.app_name)} 11",
            "${getString(R.string.app_name)} 12",
            "${getString(R.string.app_name)} 13",
            "${getString(R.string.app_name)} 14",
            "${getString(R.string.app_name)} 15",
            "${getString(R.string.app_name)} 16",
            "${getString(R.string.app_name)} 17",
            "${getString(R.string.app_name)} 18",
            "${getString(R.string.app_name)} 19",
            "${getString(R.string.app_name)} 20"
        )
        binding.stackView.adapter = StackedCardsAdapter(applicationContext, data)
        binding.stackView.onChangeListener = object : OnChangeListener {
            override fun onChange(remainingCardsCount: Int, totalCardsCount: Int) {
                Log.d("StackView", "remainingCardsCount :: $remainingCardsCount, totalCardsCount :: $totalCardsCount")
            }
        }



    }

    class StackedCardsAdapter(
        private val context: Context,
        private val data: List<String>
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
            parent: ViewGroup?
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

}




