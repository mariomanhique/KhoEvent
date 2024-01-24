package com.mariomanhique.khoevent.presentation.screens.home

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mariomanhique.khoevent.presentation.screens.home.HomeContent

@Composable
fun HomeScreen(
    onMenuClicked: () -> Unit = {},
){

    HomeContent(
        onMenuClicked = onMenuClicked,
        searchValue = "",
        onValueChange = {}
    )
}


