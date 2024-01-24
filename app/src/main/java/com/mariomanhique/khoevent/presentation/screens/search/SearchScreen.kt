package com.mariomanhique.khoevent.presentation.screens.search

import androidx.compose.runtime.Composable
import com.mariomanhique.khoevent.presentation.screens.search.SearchContent

@Composable
fun SearchScreen(
    onSearchClicked: () -> Unit,
){
    SearchContent(
        "",
        onValueChange = {},
        onSearchClicked = onSearchClicked
    )
}

