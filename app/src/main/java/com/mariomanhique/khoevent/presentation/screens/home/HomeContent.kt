package com.mariomanhique.khoevent.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mariomanhique.khoevent.R
import com.mariomanhique.khoevent.model.Communities
import com.mariomanhique.khoevent.model.Event
import com.mariomanhique.khoevent.presentation.components.EventCard
import com.mariomanhique.khoevent.presentation.components.ScreenSection
import com.mariomanhique.khoevent.presentation.components.SearchBar
import com.mariomanhique.khoevent.utils.KhoButtonsColors
import com.mariomanhique.khoevent.utils.fontFamily

@Composable
fun HomeContent(
    communities: Communities,
    navigateToEventDetails: () -> Unit,
    events: List<Event>,
    onMenuClicked: () -> Unit = {},
    searchValue: String,
    onSearchValueChange: (String) -> Unit,
) {

    LazyVerticalGrid(
        columns = object : GridCells{
            override fun Density.calculateCrossAxisCellSizes(
                availableSize: Int,
                spacing: Int
            ): List<Int> {
                val firstColumn = (availableSize - spacing) * 2 / 4 // this gives us the value of the second grid times 2
                val secondColumn = availableSize - spacing - firstColumn

                return listOf(firstColumn, secondColumn)
            }
        },
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(rememberNestedScrollInteropConnection())
    ){

        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item(
            span = {
                GridItemSpan(maxLineSpan)
            },
//            key = localDate
        ) {
            Row {
                SearchBar(
                    Modifier
                        .fillMaxWidth(0.85f)
                        .padding(horizontal = 16.dp),
                    searchValue = searchValue,
                    onSearchClicked = {},
                    onValueChange = onSearchValueChange
                )

                IconButton(
                    onClick = onMenuClicked
                ) {
                    Image(
                        modifier = Modifier.size(50.dp),
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "",
//                        tint = KhoButtonsColors.buttonColor
                    )
                }
            }
        }

        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            ScreenSection(
                modifier = Modifier.paddingFromBaseline(top = 0.dp, bottom = 0.dp),
                title = R.string.communities_section
            ) {
                CommunityCardListList(
                    communities
                )
            }
        }


        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            Text(
                text = stringResource(id = R.string.next_events),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 19.sp,
                    fontFamily = fontFamily(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.secondary
                ),
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                    .padding(horizontal = 16.dp)
            )
        }

        items(events){
            EventCard(
                title = it.title,
                navigateToEventDetails = navigateToEventDetails
            )
        }

        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        ) {
            Spacer(modifier = Modifier.height(8.dp))
        }

    }

}

@Composable
fun CommunityCard(
    name: String,
    eventCount: String,
){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.inverseOnSurface
    ) {
        Column(
            modifier = Modifier
                .width(250.dp)
                .height(350.dp)
                .clickable {
                }
                .padding(10.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .height(240.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.mozdev)
                    .crossfade(enable = true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = "Gallery Image"
            )
            Column(
                modifier = Modifier
                    .padding(vertical = 10.dp)
            ) {
                Text(text = name,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 25.sp,
                        fontFamily = fontFamily(
                            fontWeight = FontWeight.Bold
                        ),
                        color = KhoButtonsColors.white
                    ),
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = "Eventos: $eventCount",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 20.sp,
                        fontFamily = fontFamily(),
                        color = MaterialTheme.colorScheme.secondary
                    )
                )
            }
        }
    }
}



@Composable
fun CommunityCardListList(
    communities: Communities
){
    LazyRow(
//        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(items = communities){
            CommunityCard(
                name = it.name,
                eventCount = "15"
            )
        }
    }
}



