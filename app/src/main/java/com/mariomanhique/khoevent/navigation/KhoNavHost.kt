package com.mariomanhique.khoevent.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mariomanhique.khoevent.presentation.screens.auth.signIn.navigation.signInRoute
import com.mariomanhique.khoevent.presentation.screens.auth.signUp.navigation.navigateToSignUp
import com.mariomanhique.khoevent.presentation.screens.auth.signUp.navigation.signUpRoute
import com.mariomanhique.khoevent.presentation.screens.home.navigation.homeRoute
import com.mariomanhique.khoevent.presentation.screens.search.navigation.navigateToSecondSearch
import com.mariomanhique.khoevent.presentation.screens.search.navigation.searchGraph
import com.mariomanhique.khoevent.presentation.screens.search.navigation.secondSearchRoute

@Composable
fun KhoNavHost(
    startDestination: String = homeRoute,
    onMenuClicked: () -> Unit = {},
    paddingValues: PaddingValues
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){

        signInRoute(
            navigateToHome = {

            },
            navigateToSignUp = {
                navController.navigateToSignUp()
            }
        )
        signUpRoute(
            navigateToHome = {

            },
            navigateToSignIn = {

            })

        homeRoute(
            onMenuClicked = onMenuClicked
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