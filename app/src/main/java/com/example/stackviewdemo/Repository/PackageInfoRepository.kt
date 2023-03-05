package com.example.stackviewdemo.Repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.networklayer.dataSource.PackageInfoDataSource
import com.example.networklayer.resopnse.PackageInfoListResponse
import com.example.networklayer.resopnse.genericResopnse.BaseResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class PackageInfoRepository @Inject constructor(private val packageInfoDataSource: PackageInfoDataSource) {

    private val parentJob = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + parentJob)

    fun getPackagesInfoList(): LiveData<BaseResponse<PackageInfoListResponse>> {
        val getCreditCardInfoResponse = MutableLiveData<BaseResponse<PackageInfoListResponse>>()
        getCreditCardInfoResponse.postValue(BaseResponse.loading());
        coroutineScope.launch {
            try {
                val request = packageInfoDataSource.getPackageInfo()
                if (request.isSuccessful) {
                    getCreditCardInfoResponse.postValue(BaseResponse.success(request.body()!!))
                } else {
                    getCreditCardInfoResponse.postValue(
                        BaseResponse.error(
                            "Network Issue"
                        )
                    )
                }
            } catch (e: Exception) {
                getCreditCardInfoResponse.postValue(BaseResponse.error(e.localizedMessage))
            }
        }
        return getCreditCardInfoResponse
    }

}