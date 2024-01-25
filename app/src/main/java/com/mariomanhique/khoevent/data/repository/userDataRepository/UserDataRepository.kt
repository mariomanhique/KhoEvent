package com.mariomanhique.khoevent.data.repository.userDataRepository

import com.mariomanhique.khoevent.model.DarkThemeConfig
import com.mariomanhique.khoevent.model.ThemeBrand
import com.mariomanhique.khoevent.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {

    /**
     * Stream of [UserData]
     */
    val userData: Flow<UserData>
    /**
     * Sets the desired theme brand.
     */

    suspend fun setAccessToken(accessToken:String)

}