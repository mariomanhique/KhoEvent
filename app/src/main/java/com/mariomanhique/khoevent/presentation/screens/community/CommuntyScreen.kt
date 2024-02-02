package com.mariomanhique.khoevent.presentation.screens.community

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mariomanhique.khoevent.model.Event
import com.mariomanhique.khoevent.model.Result
import com.mariomanhique.khoevent.presentation.screens.home.HomeViewModel

@Composable
fun CommunityScreen(
    onValueChange: (String) -> Unit,
    navigateToEventDetails: () -> Unit,
    homeViewModel: CommunityViewModel = hiltViewModel()
){
    var searchValue by remember {
        mutableStateOf("")
    }

    val eventsList by homeViewModel.events.collectAsStateWithLifecycle()

    when(eventsList){
       is Result.Success -> {
            CommunityContent(
                searchValue = searchValue,
                onValueChange = {
                    searchValue = it
                },
                eventsList = (eventsList as Result.Success<List<Event>>).data,
                navigateToEventDetails = navigateToEventDetails
            )
        } else ->{

        }
    }

}