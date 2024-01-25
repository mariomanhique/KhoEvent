package com.mariomanhique.khoevent.presentation.screens.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mariomanhique.khoevent.R
import com.mariomanhique.khoevent.model.Event
import com.mariomanhique.khoevent.model.eventList
import com.mariomanhique.khoevent.presentation.components.SearchBar
import com.mariomanhique.khoevent.presentation.screens.home.EventsVerticalGridList

@Composable
fun CommunityContent(
    eventsList: List<Event>,
    searchValue: String,
    onValueChange: (String) -> Unit,
){
    Column(
        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            SearchBar(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                searchValue = searchValue,
                onSearchClicked = {},
                onValueChange = onValueChange
            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        EventsVerticalGridList(list = eventsList)
    }
}