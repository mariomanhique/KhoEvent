package com.mariomanhique.khoevent.presentation.screens.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mariomanhique.khoevent.presentation.screens.details.EventDetailsScreen

const val eventDetailsRoute = "eventDetailsRoute"

fun NavController.navigateToEventDetails(){
    navigate(eventDetailsRoute)
}


fun NavGraphBuilder.eventDetailsRoute(){
    composable(eventDetailsRoute){
        EventDetailsScreen()
    }
}