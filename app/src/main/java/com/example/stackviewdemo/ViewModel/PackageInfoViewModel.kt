package com.example.stackviewdemo.ViewModel



import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.networklayer.resopnse.PackageInfoListResponse
import com.example.networklayer.resopnse.genericResopnse.BaseResponse
import com.example.stackviewdemo.Repository.PackageInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PackageInfoViewModel @Inject constructor(private var packageInfoRepository: PackageInfoRepository): ViewModel(){

    fun getAllPackageInfo(): LiveData<BaseResponse<PackageInfoListResponse>> {
        return packageInfoRepository.getPackagesInfoList()
    }

}