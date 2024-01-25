package com.mariomanhique.khoevent.network

import com.mariomanhique.khoevent.model.AuthenticationRequest
import com.mariomanhique.khoevent.model.Communities
import com.mariomanhique.khoevent.model.Event
import com.mariomanhique.khoevent.model.EventRequest
import com.mariomanhique.khoevent.model.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface KhoEventsApi {

    @GET("communities")
    suspend fun getCommunities(): Communities

    @GET("events")
    suspend fun getEvents():List<Event>

    @GET("events/{id}")
    suspend fun getEventsById():List<Event>

    @POST("auth/authenticate")
    suspend fun authenticateUser(@Body request: AuthenticationRequest): Response<TokenResponse>


    @POST("events/{id}")
    suspend fun createEvent(
        @Header("Authorization") authorizationHeader: String,
        @Path("id") communityId: Long,
        @Body request: EventRequest
    ): Response<String>
}




