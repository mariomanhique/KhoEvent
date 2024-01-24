package com.mariomanhique.khoevent.presentation.screens.community.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mariomanhique.khoevent.presentation.screens.community.CommunityScreen

const val communityRoute = "communityRoute"
fun NavController.navigateToCommunity(){
    navigate(communityRoute)
}

fun NavGraphBuilder.communityRoute(
    onValueChange: (String) -> Unit,
){
    composable(communityRoute){
        CommunityScreen(
            onValueChange = onValueChange
        )
    }
}