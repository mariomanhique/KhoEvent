package com.mariomanhique.khoevent.presentation.screens.community

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun CommunityScreen(
    onValueChange: (String) -> Unit,
){
    var searchValue by remember {
        mutableStateOf("")
    }

    CommunityContent(
        searchValue = searchValue,
        onValueChange
    )
}