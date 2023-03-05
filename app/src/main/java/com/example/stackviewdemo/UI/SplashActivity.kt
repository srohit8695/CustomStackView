package com.example.stackviewdemo.UI


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.networklayer.resopnse.responseStatus.Status
import com.example.stackviewdemo.Model.StackViewPackageInfo
import com.example.stackviewdemo.R
import com.example.stackviewdemo.Util.Utility
import com.example.stackviewdemo.ViewModel.PackageInfoViewModel
import com.example.stackviewdemo.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    private lateinit var packageInfoViewModel : PackageInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.splashImg.setOnClickListener {
            val move = Intent(this,MainActivity::class.java)
            startActivity(move)
        }

        packageInfoViewModel = ViewModelProvider(this)[PackageInfoViewModel::class.java]
        val tempData = packageInfoViewModel.getAllPackageInfo()



            tempData.observe(this, Observer{
                when(it.status){
                    Status.SUCCESS -> {

                        it.data.let {
//                            Toast.makeText(this,it!!.message.toString(), Toast.LENGTH_SHORT).show()

                            if (it != null) {
                                Utility.packageInfoList = it.data
                            }
                            Executors.newSingleThreadScheduledExecutor().schedule({
                                val move = Intent(this,MainActivity::class.java)
                                startActivity(move)
                            }, 2, TimeUnit.SECONDS)

                        }

                    }
                    Status.LOADING -> {}
                    Status.ERROR -> {}
                }
            })




    }
}