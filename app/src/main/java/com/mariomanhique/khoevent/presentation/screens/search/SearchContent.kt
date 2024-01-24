package com.mariomanhique.khoevent.presentation.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mariomanhique.khoevent.presentation.components.SearchBar

@Composable
fun SearchContent(
    searchValue: String,
    onValueChange: (String) -> Unit,
    onSearchClicked: () -> Unit,
) {
    Column {
        SearchBar(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            searchValue = searchValue,
            onValueChange = onValueChange,
            onSearchClicked = onSearchClicked
        )

//        ScreenSection(
//            title = R.string.tags) {
//
//        }
    }
}

@Composable
fun BrowseByTagsList(){
    LazyVerticalGrid(columns = GridCells.Fixed(2)){

    }
}

@Composable
fun BrowseByTagsCard(){

}





