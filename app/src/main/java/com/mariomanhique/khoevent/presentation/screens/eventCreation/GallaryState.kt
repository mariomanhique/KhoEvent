package com.mariomanhique.khoevent.presentation.screens.eventCreation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

//will allow to remember ProfileState across multiple recompositions
@Composable
fun rememberGalleryState(): GallaryState {
    return remember { GallaryState() }
}

class ProfileState {
    val image = mutableStateOf<GallaryState>(GallaryState())

    fun addImageProfile(galleryImage: GallaryState) {
        image.value = galleryImage
    }
}

/**
 * A class that represents a single Image within a Gallery.
 * @param image The image URI inside a gallery.
 * @param remoteImagePath The path of the [image] where you plan to upload it.
 * */
data class GallaryState(
    val image: Uri = Uri.EMPTY,
    val remoteImagePath: String = "",
)