package com.mariomanhique.khoevent.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mariomanhique.khoevent.utils.KhoButtonsColors
import com.mariomanhique.khoevent.utils.fontFamily

@Composable
fun KhoButton(
    modifier: Modifier = Modifier,
    @StringRes buttonText: Int,
    buttonEnabled: Boolean,
    onClicked: () -> Unit,
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .heightIn(max = 70.dp, min = 50.dp),
            enabled = buttonEnabled,
            onClick = onClicked,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = KhoButtonsColors.buttonColor,
            )
        ) {
            Text(
                modifier = Modifier
                    .paddingFromBaseline(top = 70.dp, bottom = 20.dp),
                text = stringResource(id = buttonText),
                fontFamily =  fontFamily(
                ),
                fontSize = 20.sp
            )
        }

    }
}




