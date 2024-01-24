package com.mariomanhique.khoevent.presentation.screens.search

import androidx.compose.runtime.Composable
import com.mariomanhique.khoevent.presentation.screens.search.SecondSearchContent

@Composable
fun SecondSearchScreen(
    onBackClicked: () -> Unit,
){
    SecondSearchContent(
        onBackClicked = onBackClicked,
        searchValue = "",
        onValueChange ={

        },
        onActionClicked = {

        }
    )
}