package com.mariomanhique.khoevent.presentation.screens.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mariomanhique.khoevent.presentation.screens.home.HomeScreen

const val homeRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null){
    navigate(homeRoute, navOptions)
}

fun NavGraphBuilder.homeRoute(
    onMenuClicked: () -> Unit = {},
){
    composable(homeRoute){
        HomeScreen(
            onMenuClicked = onMenuClicked
        )
    }
}