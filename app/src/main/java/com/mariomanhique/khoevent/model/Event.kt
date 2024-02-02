package com.mariomanhique.khoevent.model

data class Event(
    val description: String,
    val endTime: String,
    val eventDate: String,
    val eventLimit: Int,
    val id: Int,
    val startTime: String,
    val title: String
)

