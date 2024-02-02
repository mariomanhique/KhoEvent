package com.mariomanhique.khoevent.presentation.screens.community

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.mariomanhique.khoevent.model.Event
import com.mariomanhique.khoevent.presentation.components.EventCard
import com.mariomanhique.khoevent.presentation.components.SearchBar
import com.mariomanhique.khoevent.presentation.screens.home.CommunityCard

@Composable
fun CommunityContent(
    eventsList: List<Event>,
    searchValue: String,
    navigateToEventDetails: () -> Unit,
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
        EventsVerticalGridList(
            list = eventsList,
            navigateToEventDetails = navigateToEventDetails
            )
    }
}

@Composable
fun EventsVerticalGridList(
    list: List<Event>,
    navigateToEventDetails: () -> Unit,
    ){
    LazyVerticalGrid(
        columns = object : GridCells {
            override fun Density.calculateCrossAxisCellSizes(
                availableSize: Int,
                spacing: Int
            ): List<Int> {
                val firstColumn = (availableSize - spacing) * 2 / 4 // this gives us the value of the second grid times 2
                val secondColumn = availableSize - spacing - firstColumn

                return listOf(firstColumn, secondColumn)
            }
        },
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(items = list){
            EventCard(
                title = it.title,
                navigateToEventDetails = navigateToEventDetails
                )
        }
    }
}