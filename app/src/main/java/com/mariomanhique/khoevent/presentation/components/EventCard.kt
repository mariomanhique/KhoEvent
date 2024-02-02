package com.mariomanhique.khoevent.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mariomanhique.khoevent.R

@Composable
fun EventCard(
    title: String,
    navigateToEventDetails: () -> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.inverseOnSurface
    ) {
        Box(
            modifier = Modifier
                .clickable {
                    navigateToEventDetails()
                }
                .padding(5.dp)
        ){

            val topRadius = MaterialTheme.shapes.medium
            Column {
                AsyncImage(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(
                            topStart = topRadius.topStart,
                            topEnd = topRadius.topEnd,
                            bottomEnd = CornerSize(0.dp),
                            bottomStart = CornerSize(0.dp)

                        ))
                        .width(200.dp)
                        .height(200.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.mozdev)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Gallery Image"
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
//                        .align(Alignment.BottomEnd)
                ) {
                    Text(text = title)
                    Text(text = "2024-12-03 | 08:30")
                    Text(text = "ISB")
                }
            }


        }

    }
}