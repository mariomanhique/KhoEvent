package com.mariomanhique.khoevent.presentation.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mariomanhique.khoevent.R
import com.mariomanhique.khoevent.utils.KhoButtonsColors
import com.mariomanhique.khoevent.utils.fontFamily


@Composable
fun EventDetailsContent() {
    Column(
        modifier = Modifier.fillMaxSize()
//        verticalArrangement =
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
//            contentAlignment = Alignment.BottomCenter
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.mozdev)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = "Gallery Image"
            )
            Box(
                modifier = Modifier.align(Alignment.BottomCenter),
            ) {
                Column(
                    modifier = Modifier
                        .padding(15.dp),
//                        .fillMaxSize()
//                        .align(alignment = Alignment.BottomCenter),
                verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(text = "Data Wave".uppercase(),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = 30.sp,
                            fontFamily = fontFamily(
                                fontWeight = FontWeight.Bold
                            ),
                            color = KhoButtonsColors.white
                        ),
                        )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "Data: 2024-04-05")
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(text = "Local: UEM - Faculdade de Engenhariaa")
                        }
                        FloatingActionButton(
                            modifier = Modifier
                                .size(65.dp),
                            shape = MaterialTheme.shapes.small,
                            containerColor = KhoButtonsColors.buttonColor,
                            onClick = {}
                        ) {
                            Box(
                                modifier = Modifier
                            ) {
                                Icon(
                                    modifier = Modifier,
                                    imageVector = Icons.Default.Add,
                                    tint = KhoButtonsColors.white,
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                }
            }
        }

        Divider()

        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(text = "O que é DATA WAVE?")
            Text(text = "s simply dummy text of the printing and " +
                    "typesetting industry. Lorem Ipsum has been the " +
                    "industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled" +
                    " it to make a type specimen book. It has")
        }

    }
}

