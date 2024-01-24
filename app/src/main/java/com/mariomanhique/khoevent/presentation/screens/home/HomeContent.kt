package com.mariomanhique.khoevent.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mariomanhique.khoevent.R
import com.mariomanhique.khoevent.model.Event
import com.mariomanhique.khoevent.model.eventList
import com.mariomanhique.khoevent.presentation.components.ScreenSection
import com.mariomanhique.khoevent.presentation.components.SearchBar
import com.mariomanhique.khoevent.utils.fontFamily

@Composable
fun HomeContent(
    onMenuClicked: () -> Unit = {},
    searchValue: String,
    onValueChange: (String) -> Unit,
) {

    LazyVerticalGrid(
        columns = object : GridCells{
            override fun Density.calculateCrossAxisCellSizes(
                availableSize: Int,
                spacing: Int
            ): List<Int> {
                val firstColumn = (availableSize - spacing) * 2 / 4 // this gives us the value of the second grid times 2
                val secondColumn = availableSize - spacing - firstColumn
                val thirdColumn = availableSize - spacing - firstColumn - secondColumn

                return listOf(firstColumn, secondColumn)
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(rememberNestedScrollInteropConnection())
    ){

        item {
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
                    onValueChange = onValueChange
                )

                IconButton(
                    onClick = onMenuClicked
                ) {
                    Image(
                        painterResource(id = R.drawable.menu),
                        contentDescription = "",
                        modifier = Modifier.size(40.dp)
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
                    eventList
                )
            }
        }

//        item {
//            ScreenSection(title = R.string.next_events) {
//                EventsVerticalGridList(list = eventList)
//            }
//        }

//        item {
//
//        }


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

        gridList(eventList)

        item {
            Spacer(modifier = Modifier.height(8.dp))
        }



    }

}

fun LazyListScope.sublist( list: List<Event>){
    items(items = list){
        CommunityCard(id = it.id, title = it.title)
    }
}



@Composable
fun CommunityCard(
    id: Int,
    title: String,
){
    Surface {
        Column {
            AsyncImage(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(all = 8.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.cover_book)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = "Gallery Image"
            )
            Text(text = title)
            Text(text = "Eventos:16")
        }
    }
}

//fun LazyGridItemScope.gridList(
//
//){
//
//}

fun LazyGridScope.gridList(
    list: List<Event>

){

    items(list){
        CommunityCard(id = it.id, title = it.title)
    }
}

@Composable
fun EventsVerticalGridList(
    list: List<Event>
){
    LazyVerticalGrid(
        columns = object : GridCells{
            override fun Density.calculateCrossAxisCellSizes(
                availableSize: Int,
                spacing: Int
            ): List<Int> {
                val firstColumn = (availableSize - spacing) * 2 / 4 // this gives us the value of the second grid times 2
                val secondColumn = availableSize - spacing - firstColumn
                val thirdColumn = availableSize - spacing - firstColumn - secondColumn

                return listOf(firstColumn, secondColumn)
            }
        }
    ){
        items(items = list){
            CommunityCard(id = it.id, title = it.title)
        }
    }
}

@Composable
fun CommunityCardListList(
    eventsList:List<Event>
){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ){
        items(items = eventsList){
            CommunityCard(
                it.id,
                it.title
            )
        }
    }
}
@Composable
fun ContinueReadingCard(
    image:String,
    title: String,
    authors: List<String>,
    bookNumber: Int? = null,
    maxBookNumber: Int? = null
){
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
       Surface(
           modifier = Modifier
               .width(80.dp)
               .height(100.dp)

           ,
           color = Color.Cyan
       ) {
           AsyncImage(
               modifier = Modifier
                   .width(80.dp)
                   .height(100.dp)
                   .padding(all = 16.dp),
               model = ImageRequest.Builder(LocalContext.current)
                   .data(image)
                   .crossfade(true)
                   .build(),
               contentScale = ContentScale.Crop,
               contentDescription = "Gallery Image"
           )
       }

        Column(
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            Text(text = title)

            var authorsName =""
            authors.forEach {
                authorsName += "$it& "
            }
            Text(text = authorsName.removeSuffix("& "))
            LinearProgressIndicator(progress = 1f)
            Text(text = "UserBook $bookNumber of $maxBookNumber")

        }
    }
}


