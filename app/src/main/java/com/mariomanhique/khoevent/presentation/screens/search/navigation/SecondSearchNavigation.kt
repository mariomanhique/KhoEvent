package com.mariomanhique.khoevent.presentation.screens.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mariomanhique.khoevent.presentation.screens.search.SecondSearchScreen


const val secondSearchRoute = "second_search_route"

fun NavController.navigateToSecondSearch(){
    navigate(secondSearchRoute){
        launchSingleTop = true
    }
}

fun NavGraphBuilder.secondSearchRoute(
    onBackClicked: () -> Unit,
){
    composable(secondSearchRoute){
        SecondSearchScreen(
            onBackClicked = onBackClicked
        )
    }

}