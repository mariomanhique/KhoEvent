package com.mariomanhique.khoevent.presentation.screens.eventCreation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mariomanhique.khoevent.presentation.screens.eventCreation.CreateEventScreen

const val createEventRoute = "createEventRoute"
fun NavController.navigateToCreateEvent(){
    navigate(createEventRoute)
}


fun NavGraphBuilder.createEventRoute(
    navigateToCommunityEvents: () -> Unit,
){
    composable(createEventRoute){
        CreateEventScreen(
            navigateToCommunityEvents = navigateToCommunityEvents
        )
    }
}