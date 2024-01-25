package com.mariomanhique.khoevent.network

import com.mariomanhique.khoevent.model.Communities
import com.mariomanhique.khoevent.model.Event
import com.squareup.moshi.Json
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HEAD
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



    @POST("auth/authenticate")
    suspend fun authenticateUser(@Body request: AuthenticationRequest): Response<TokenResponse>


//            @GET("events")
//    suspend fun getEvents(
//        @Path(value = "id") communityId: Int
//    ):
}


data class AuthenticationRequest(
    val email: String,
    val password: String
)

data class TokenResponse(
    val accessToken: String
)