package com.mariomanhique.khoevent.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mariomanhique.khoevent.utils.fontFamily

@Composable
fun ScreenSection(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @StringRes action: Int? = null,
    onActionClicked: () -> Unit = {},
    content: @Composable () -> Unit,
){
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 19.sp,
                    fontFamily = fontFamily(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.secondary
                ),
                modifier = modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                    .padding(horizontal = 16.dp)
            )
            action?.let {
                Text(
                    text = stringResource(id = action),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                        .padding(horizontal = 16.dp)
                        .clickable {
                            onActionClicked()
                        }
                )
            }
        }
        content()
    }
}