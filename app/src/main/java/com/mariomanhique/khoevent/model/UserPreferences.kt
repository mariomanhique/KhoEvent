package com.mariomanhique.khoevent.model

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    var themeBrand: ThemeBrandProto = ThemeBrandProto.THEME_BRAND_DEFAULT,
    var darkThemeConfigProto: DarkThemeConfigProto = DarkThemeConfigProto.DARK_THEME_CONFIG_FOLLOW_SYSTEM,
    var useDynamicColor: Boolean = true,
    var shouldHideOnboarding: Boolean = false,
)

enum class DarkThemeConfigProto {
    DARK_THEME_CONFIG_UNSPECIFIED,
    DARK_THEME_CONFIG_FOLLOW_SYSTEM,
    DARK_THEME_CONFIG_LIGHT,
    DARK_THEME_CONFIG_DARK,
//    UNRECOGNIZED
}

enum class ThemeBrandProto {
    THEME_BRAND_UNSPECIFIED,
    THEME_BRAND_DEFAULT,
    THEME_BRAND_ANDROID,
//    UNRECOGNIZED
}
