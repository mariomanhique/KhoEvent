package com.mariomanhique.khoevent.data.repository

import com.mariomanhique.khoevent.model.Communities

interface KhoEventsRepoInterface {

    suspend fun getCommunities(): Communities

}