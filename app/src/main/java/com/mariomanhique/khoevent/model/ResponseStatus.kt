package com.mariomanhique.khoevent.model

data class ResponseStatus(
    val createdAt: String,
    val responseCode: Int,
    val responseMessage: String,
    val responseStatus: String
)