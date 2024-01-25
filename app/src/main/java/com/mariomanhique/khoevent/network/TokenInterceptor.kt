//package com.mariomanhique.khoevent.network
//
//import android.util.Log
//import com.mariomanhique.khoevent.data.repository.userDataRepository.UserDataRepository
//import kotlinx.coroutines.CoroutineDispatcher
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.flow.map
//import kotlinx.coroutines.withContext
//import okhttp3.Interceptor
//import okhttp3.Response
//import javax.inject.Inject
//
//class TokenInterceptor @Inject constructor(
//    private val userDataRepository: UserDataRepository,
//) : Interceptor {
//
//    private var token: String? = null
//
//
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val originalRequest = chain.request()
//
//
//        Log.d("Interceptopr", "intercept: $token")
//
//        // You need to obtain the token from your storage or wherever it's stored
////        val token: String? = userDataRepository.userData// Get the token from your storage
//
//        // Add the Authorization header if the token is available
//        userDataRepository.userData.map {
//
//        }
//
////        if(token != null) {x
//          return  chain.proceed(originalRequest.newBuilder()
//                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnZGdAZ21haWwuY29tIiwiaWF0IjoxNzA2MjA1NDczLCJleHAiOjE3MDYyOTE4NzN9.c3CTixcxJmwTfiBL1peKAckUlVmESIsJ-RYT8_UyBr4")
//                .build())
////        } else {
////            return chain.proceed(originalRequest)
////
////        }
//
//
//    }
//}