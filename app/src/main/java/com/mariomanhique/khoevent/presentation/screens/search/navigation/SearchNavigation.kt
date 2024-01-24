package com.mariomanhique.khoevent.presentation.screens.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mariomanhique.khoevent.presentation.screens.search.SearchScreen


const val SEARCH_GRAPH_ROUTE_PATTERN = "search_graph"
const val searchRoute = "search_route"

fun NavController.navigateToSearchGraph(navOptions: NavOptions? = null){
    navigate(SEARCH_GRAPH_ROUTE_PATTERN, navOptions)
}

fun NavGraphBuilder.searchGraph(
    onSearchClicked: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
){
    navigation(
        route = SEARCH_GRAPH_ROUTE_PATTERN,
        startDestination = searchRoute
    ){

        composable(searchRoute){
            SearchScreen(
                onSearchClicked = onSearchClicked
            )
        }
        nestedGraphs()
    }

}