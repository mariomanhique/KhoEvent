package com.mariomanhique.africanpages.data.repository.userDataRepository

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
    suspend fun setThemeBrand(themeBrand: ThemeBrand)

    /**
     * Sets the desired dark theme config.
     */
    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)

    /**
     * Sets the preferred dynamic color config.
     */
    suspend fun setDynamicColorPreference(useDynamicColor: Boolean)

    suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean)

}