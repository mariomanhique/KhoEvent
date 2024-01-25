package com.mariomanhique.khoevent.model

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val accessToken: String =""
)


