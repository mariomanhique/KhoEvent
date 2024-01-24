package com.mariomanhique.khoevent.network

import com.mariomanhique.khoevent.model.Communities
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface KhoEventsApi {

    @GET("communities")
   suspend fun getCommunities(): Communities
}