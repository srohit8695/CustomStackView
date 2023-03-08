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
import com.example.customstackview.OnChangeListener
import com.example.stackviewdemo.Adapter.StackedCardsAdapter
import com.example.stackviewdemo.Adapter.StckedViewPackageInfoAdapter
import com.example.stackviewdemo.R
import com.example.stackviewdemo.Util.Utility
import com.example.stackviewdemo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
//        runDemo()

    }

    private fun loadData(){
        binding.stackView.adapter = StckedViewPackageInfoAdapter(this, Utility.packageInfoList)

        binding.stackView.onChangeListener = object : OnChangeListener {
            override fun onChange(remainingCardsCount: Int, totalCardsCount: Int) {
                updateScreen(remainingCardsCount,totalCardsCount)
            }
        }
        updateScreen(0,0)
    }

    private fun updateScreen(remainingCardsCount: Int, totalCardsCount: Int){

        val indexOf = totalCardsCount - remainingCardsCount
        if(indexOf<totalCardsCount &&
            Utility.packageInfoList[indexOf].pricingInfo.isNotEmpty()
        ){
            binding.nosOfScreen.text = Utility.packageInfoList[indexOf].pricingInfo[0].screensInfo[0].numberOfScreens.toString()
            binding.billedAnually.text = "Rs ${Utility.packageInfoList[indexOf].pricingInfo[0].screensInfo[0].price.toString()}"
            binding.duration.text = Utility.packageInfoList[indexOf].pricingInfo[0].duration.toString()
        }

    }

    private fun runDemo(){
        try {
            val data = listOf(
                "${getString(R.string.app_name)} 1",
                "${getString(R.string.app_name)} 2",
                "${getString(R.string.app_name)} 3",
                "${getString(R.string.app_name)} 4",
                "${getString(R.string.app_name)} 5",
                "${getString(R.string.app_name)} 6",
                "${getString(R.string.app_name)} 7",
                "${getString(R.string.app_name)} 8"
            )
            binding.stackView.adapter = StackedCardsAdapter(this, data)

            binding.stackView.onChangeListener = object : OnChangeListener {
                override fun onChange(remainingCardsCount: Int, totalCardsCount: Int) {
                    Toast.makeText(baseContext,remainingCardsCount.toString(),Toast.LENGTH_SHORT).show()
                    Log.d("StackView", "remainingCardsCount :: $remainingCardsCount, totalCardsCount :: $totalCardsCount")

                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}




