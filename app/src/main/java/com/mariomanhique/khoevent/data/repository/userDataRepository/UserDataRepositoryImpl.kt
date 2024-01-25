package com.mariomanhique.khoevent.data.repository.userDataRepository

import androidx.datastore.core.DataStore
import com.mariomanhique.khoevent.model.UserData
import com.mariomanhique.khoevent.model.UserPreferences
import javax.inject.Inject
import kotlinx.coroutines.flow.map

class UserDataRepositoryImpl @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>
): UserDataRepository {

    override val userData = userPreferences.data
        .map {
            UserData(
                accessToken = it.accessToken,
                communityEmail = it.communityEmail
            )
        }


    override suspend fun setAccessToken(accessToken: String) {
        userPreferences.updateData {
            it.copy(
                accessToken = accessToken
            )
        }
    }

    override suspend fun setCommunityEmail(communityEmail: String) {
        userPreferences.updateData {
            it.copy(
                communityEmail = communityEmail
            )
        }
    }

}