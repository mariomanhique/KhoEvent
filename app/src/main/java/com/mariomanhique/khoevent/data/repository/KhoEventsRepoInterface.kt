package com.mariomanhique.khoevent.data.repository

import com.mariomanhique.khoevent.model.Communities
import com.mariomanhique.khoevent.model.Event
import com.mariomanhique.khoevent.model.EventRequest
import com.mariomanhique.khoevent.model.ResponseStatus
import retrofit2.Call

interface KhoEventsRepoInterface {

    suspend fun getCommunities(): Communities

    suspend fun getEvents(): List<Event>
    suspend fun getEventsByCommunityId(communityId: Int): List<Event>

    suspend fun authenticateUser(email: String, password: String): String?

    suspend fun createEvent(
        authorizationHeader: String,
        communityId: Long,
        eventRequest: EventRequest
    ): String

}