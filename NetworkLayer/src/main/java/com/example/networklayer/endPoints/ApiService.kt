package com.example.networklayer.endPoints

import com.example.networklayer.constants.ApiConstants
import com.example.networklayer.resopnse.PackageInfoListResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET


interface ApiService {

    @GET(ApiConstants.GET_PACKAGES_INFO_LIST)
    suspend fun getAllBaseInfo(): Response<PackageInfoListResponse>

}