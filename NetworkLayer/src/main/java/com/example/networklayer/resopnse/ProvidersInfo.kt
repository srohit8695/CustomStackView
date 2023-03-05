package com.example.networklayer.resopnse

data class ProvidersInfo(
    val id : Any,
    val providerName : Any,
    val providerTier : Any,
    val concurrentViews : Any,
    val offeredPrice : Any,
    val enduserPrice : Any,
    val providerStatus : Any,
    val integrationType : Any,
    val stagingKey : Any,
    val productionKey : Any,
    val providerEmail : Any,
    val providerPhone : Any,
    val apiDocumentPath : Any,
    val logoPath : Any,
    val deleteFlag : Any,
    val validFrom : Any,
    val validTo : Any,
    val endpoints : Endpoints? = null,
    val optionalData : OptionalData? = null,
    val createdDate : Any,
    val updatedDate : Any
)
