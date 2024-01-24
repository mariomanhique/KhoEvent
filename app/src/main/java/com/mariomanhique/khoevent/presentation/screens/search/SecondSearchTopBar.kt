package com.mariomanhique.khoevent.presentation.screens.search

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mariomanhique.khoevent.utils.fontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondSearchTopBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    scrollBehavior: TopAppBarScrollBehavior,
){
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = title),
                fontFamily = fontFamily(
                    fontName = "Montserrat",
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ), fontSize = 20.sp
            )
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Color.Unspecified
        )

    )
}