package com.mariomanhique.khoevent.data.repository

import android.util.Log
import com.mariomanhique.khoevent.model.Communities
import com.mariomanhique.khoevent.model.CommunityItem
import com.mariomanhique.khoevent.network.KhoEventsApi
import javax.inject.Inject

class KhoEventsRepoImpl @Inject constructor (private val api: KhoEventsApi): KhoEventsRepoInterface {
    override suspend fun getCommunities(): Communities {
        Log.d("Communities", "getCommunities: ${api.getCommunities()}")
        return api.getCommunities()
    }


}