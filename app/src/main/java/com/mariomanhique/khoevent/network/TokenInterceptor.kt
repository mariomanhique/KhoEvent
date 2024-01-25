package com.mariomanhique.khoevent.network

import com.mariomanhique.khoevent.data.repository.userDataRepository.UserDataRepository
import kotlinx.coroutines.flow.map
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val userDataRepository: UserDataRepository
) : Interceptor {
    var token: String?=""
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        userDataRepository.userData.map {
           token = it.accessToken
        }

        // You need to obtain the token from your storage or wherever it's stored
//        val token: String? = userDataRepository.userData// Get the token from your storage

        // Add the Authorization header if the token is available
        val newRequest = if (token != null) {
            originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        } else {
            originalRequest
        }

        return chain.proceed(newRequest)
    }
}