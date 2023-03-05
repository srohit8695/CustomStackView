package com.example.networklayer.resopnse

data class PackageInfoListResponse(
    val status : String,
    val statusCode : Int,
    val message : String,
    val desc : String,
    val debug : String,
    val exception : String,
    val data : List<DataResponse>
)
