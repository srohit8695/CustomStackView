package com.example.networklayer.resopnse

data class ProvidersInfo(
    val id : String,
    val providerName : String,
    val providerTier : Int,
    val concurrentViews : Int,
    val offeredPrice : Int,
    val enduserPrice : Int,
    val providerStatus : Int,
    val integrationType : Int,
    val stagingKey : String,
    val productionKey : String,
    val providerEmail : String,
    val providerPhone : Int,
    val apiDocumentPath : String,
    val logoPath : String,
    val deleteFlag : Int,
    val validFrom : String,
    val validTo : String,
    val endpoints : Endpoints? = null,
    val optionalData : OptionalData? = null,
    val createdDate : String,
    val updatedDate : String
)
