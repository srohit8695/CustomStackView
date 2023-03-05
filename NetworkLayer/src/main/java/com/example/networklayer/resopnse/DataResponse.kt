package com.example.networklayer.resopnse

data class DataResponse(
    val id : String,
    val packageName : String,
    val calculatedPrice : Int,
    val sellingPrice : Int,
    val defaultTransferPrice : Int,
    val packageStatus : Int,
    val deleteFlag : Int,
    val providersInfo : List<ProvidersInfo>,
    val pricingInfo : List<PricingInfo>,
    val createdDate : String,
    val updatedDate : String
)
