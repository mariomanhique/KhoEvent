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
                accessToken = it.accessToken
            )
        }


    override suspend fun setAccessToken(accessToken: String) {
        userPreferences.updateData {
            it.copy(
                accessToken = accessToken
            )
        }
    }

}