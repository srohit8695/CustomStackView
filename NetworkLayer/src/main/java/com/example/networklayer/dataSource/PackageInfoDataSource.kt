package com.example.networklayer.dataSource

import android.app.Application
import com.example.networklayer.endPoints.ApiService
import com.example.networklayer.resopnse.PackageInfoListResponse
import com.google.gson.Gson
import retrofit2.Response
import javax.inject.Inject

class PackageInfoDataSource @Inject constructor() {

    @Inject lateinit var apiService: ApiService

    suspend fun getPackageInfo(): Response<PackageInfoListResponse>{
        return apiService.getAllBaseInfo()
    }


}