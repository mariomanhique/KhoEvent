package com.mariomanhique.khoevent.utils

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.mariomanhique.khoevent.R

fun fontFamily(
    fontName:String = "Poppins",
    fontWeight: FontWeight = FontWeight.Normal,
    fontStyle: FontStyle = FontStyle.Normal
):FontFamily{

    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    val fontNam = GoogleFont(fontName)

   return FontFamily(
        Font(
            googleFont = fontNam,
            fontProvider=provider,
            weight = fontWeight,
            style= fontStyle)
    )
}