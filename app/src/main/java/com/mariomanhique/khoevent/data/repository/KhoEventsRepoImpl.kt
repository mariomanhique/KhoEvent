package com.mariomanhique.khoevent.data.repository

import android.util.Log
import com.mariomanhique.khoevent.model.Communities
import com.mariomanhique.khoevent.model.Event
import com.mariomanhique.khoevent.network.AuthenticationRequest
import com.mariomanhique.khoevent.network.KhoEventsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class KhoEventsRepoImpl @Inject constructor (private val api: KhoEventsApi): KhoEventsRepoInterface {
    override suspend fun getCommunities(): Communities {
        Log.d("Communities", "getCommunities: ${api.getCommunities()}")
        return api.getCommunities()
    }

    override suspend fun getEvents(): List<Event> {
        return api.getEvents()
    }

   override suspend fun authenticateUser(email: String, password: String): String? {
      return try {
          val response = api.authenticateUser(AuthenticationRequest(email, password))

          if (response.isSuccessful) {
              Log.d("Authentication ", "authenticateUser:${response.body()} ")
              response.body()?.accessToken

              // Handle the token
          } else {
              // Handle the error response
              val errorBody = response.errorBody()?.string()
              Log.d("Authentication ", "error:$errorBody ")
              errorBody
          }
      } catch (e: Exception){
          e.message.toString()
      }

    }

}