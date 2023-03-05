package com.example.networklayer.resopnse

data class DataResponse(
    val id : Any,
    val packageName : Any,
    val calculatedPrice : Any,
    val sellingPrice : Any,
    val defaultTransferPrice : Any,
    val packageStatus : Any,
    val deleteFlag : Any,
    val providersInfo : List<ProvidersInfo>,
    val pricingInfo : List<PricingInfo>,
    val createdDate : Any,
    val updatedDate : Any
)
