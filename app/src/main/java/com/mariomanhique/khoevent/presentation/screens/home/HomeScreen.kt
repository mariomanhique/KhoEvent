package com.mariomanhique.khoevent.presentation.screens.home

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mariomanhique.khoevent.model.Communities
import com.mariomanhique.khoevent.model.CommunityItem
import com.mariomanhique.khoevent.model.Result
import com.mariomanhique.khoevent.presentation.screens.home.HomeContent

@Composable
fun HomeScreen(
    onMenuClicked: () -> Unit = {},
    homeViewModel: HomeViewModel = hiltViewModel()
){

    val communities by homeViewModel.data.collectAsStateWithLifecycle()
    val events by homeViewModel.events.collectAsStateWithLifecycle()

    when(communities){
        is Result.Success -> {
            HomeContent(
                communities = (communities as Result.Success<Communities>).data,
                events = events,
                onMenuClicked = onMenuClicked,
                searchValue = "",
                onValueChange = {}
            )
        }
        is Result.Error -> {

        }

        else -> {

        }
    }


}


