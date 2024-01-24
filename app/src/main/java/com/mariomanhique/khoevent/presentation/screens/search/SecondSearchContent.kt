package com.mariomanhique.khoevent.presentation.screens.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mariomanhique.khoevent.presentation.components.SearchBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class,
    ExperimentalLayoutApi::class
)
@Composable
fun SecondSearchContent(
    onBackClicked: () -> Unit,
    searchValue: String,
    onValueChange: (String) -> Unit,
    onActionClicked: () -> Unit,
) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                SearchBar(
                    Modifier
                        .fillMaxWidth(0.85f)
                        .padding(horizontal = 16.dp),
                    searchValue = searchValue,
                    onSearchClicked = {},
                    onValueChange = onValueChange
                )

//                Text(
//                    modifier = Modifier.clickable {
//                          onBackClicked()
//                    }.align(CenterVertically),
//                    text = stringResource(id = R.string.cancel),
//                    )
            }

//            ScreenSection(
//                title = R.string.recent,
//                action = R.string.clear_action,
//                onActionClicked = onActionClicked
//            ) {
//
//            }
//            ScreenSection(title = R.string.top_book_search) {
//
//            }
//
//            ScreenSection(title = R.string.top_author_search) {
//
//            }
        }


}