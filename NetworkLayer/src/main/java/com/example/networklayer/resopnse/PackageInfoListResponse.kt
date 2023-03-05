package com.example.networklayer.resopnse

data class PackageInfoListResponse(
    val status : Any,
    val statusCode : Any,
    val message : Any,
    val desc : Any,
    val debug : Any,
    val exception : Any,
    val data : List<DataResponse>
)
