package com.mariomanhique.khoevent.data.repository

import com.mariomanhique.khoevent.model.Communities
import com.mariomanhique.khoevent.model.Event
import retrofit2.Call

interface KhoEventsRepoInterface {

    suspend fun getCommunities(): Communities

    suspend fun getEvents(): List<Event>

    suspend fun authenticateUser(email: String, password: String): String?

}