package com.mariomanhique.khoevent.presentation.components

import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mariomanhique.khoevent.utils.fontFamily

@Composable
fun KhoIcon(){
    Text(
            modifier = Modifier.paddingFromBaseline(bottom = 80.dp),
        text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                fontFamily = fontFamily(
                    fontName = "Expletus Sans",
                    fontWeight = FontWeight.ExtraBold,
                ),
                color = Color.Green
            )
            ){
                append("Kho")
            }

            withStyle(
                SpanStyle(
                fontFamily = fontFamily(
                    fontName = "Expletus Sans",
                    fontWeight = FontWeight.ExtraBold,
                )
            )
            ){
                append("Event")
            }
        },
        style = TextStyle(
            fontSize = 55.sp
        )
    )
}