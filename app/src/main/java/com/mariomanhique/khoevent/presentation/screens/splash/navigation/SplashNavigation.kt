package com.mariomanhique.khoevent.presentation.screens.splash.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mariomanhique.khoevent.presentation.screens.splash.SplashScreen


const val splashRoute = "splashRoute"
fun NavGraphBuilder.splashRoute(
    navigateToHome: () -> Unit,
){
    composable(splashRoute){
        SplashScreen {
            navigateToHome()
        }
    }
}


