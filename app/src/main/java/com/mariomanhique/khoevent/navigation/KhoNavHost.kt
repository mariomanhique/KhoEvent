package com.mariomanhique.khoevent.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mariomanhique.khoevent.presentation.screens.auth.signIn.navigation.navigateToSignIn
import com.mariomanhique.khoevent.presentation.screens.auth.signIn.navigation.signInRoute
import com.mariomanhique.khoevent.presentation.screens.auth.signUp.navigation.navigateToSignUp
import com.mariomanhique.khoevent.presentation.screens.auth.signUp.navigation.signUpRoute
import com.mariomanhique.khoevent.presentation.screens.community.navigation.communityRoute
import com.mariomanhique.khoevent.presentation.screens.home.navigation.homeRoute
import com.mariomanhique.khoevent.presentation.screens.home.navigation.navigateToHome
import com.mariomanhique.khoevent.presentation.screens.search.navigation.navigateToSecondSearch
import com.mariomanhique.khoevent.presentation.screens.search.navigation.searchGraph
import com.mariomanhique.khoevent.presentation.screens.search.navigation.secondSearchRoute
import com.mariomanhique.khoevent.presentation.screens.splash.navigation.splashRoute
import com.mariomanhique.khoevent.ui.KhoAppState

@Composable
fun KhoNavHost(
    appState: KhoAppState,
    startDestination: String = homeRoute,
    onMenuClicked: () -> Unit = {},
    paddingValues: PaddingValues
) {

    val navController = appState.navController

    NavHost(navController = navController, startDestination = startDestination){

        splashRoute{
            navController.navigateToSignIn()
        }
        signInRoute(
            navigateToHome = {
                 navController.navigateToHome()
            },
            navigateToSignUp = {
                navController.navigateToSignUp()
            }
        )
        signUpRoute(
            navigateToHome = {
                 navController.navigateToHome()
            },
            navigateToSignIn = {
                navController.navigateToSignIn()
            })

        homeRoute(
            onMenuClicked = onMenuClicked
        )

        communityRoute(
            onValueChange = {}
        )

        searchGraph(
            onSearchClicked = navController::navigateToSecondSearch,
            nestedGraphs = {
                secondSearchRoute(
                    onBackClicked = navController::popBackStack
                )
            }
        )

    }

}