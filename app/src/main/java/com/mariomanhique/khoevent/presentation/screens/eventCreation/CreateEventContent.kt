package com.mariomanhique.khoevent.presentation.screens.eventCreation

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddPhotoAlternate
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mariomanhique.khoevent.R
import com.mariomanhique.khoevent.presentation.components.InputTextField
import com.mariomanhique.khoevent.utils.KhoButtonsColors

@Composable
fun CreateEventContent(
    imageProfile: Uri?,
    eventTitleValue: String,
    onEventValueChange: (String) -> Unit,
    locationValue: String,
    onLocationValueChange: (String) -> Unit,
    eventDate: String,
    onDateValueChange: (String) -> Unit,
    eventTime: String,
    onTimeValueChange: (String) -> Unit,
    eventDescription: String,
    onDescriptionValueChange: (String) -> Unit,
    eventLimit: String,
    onLimitValueChange: (String) -> Unit,
    onSaveClicked: () -> Unit,
    onCancelClicked: () -> Unit,
    onSelectImage: (Uri) -> Unit,
){

    val imageUri by remember {
        mutableStateOf(
            if (imageProfile.toString().isEmpty()) R.drawable.profile
            else imageProfile
        )
    }

    var imageSelected by remember { mutableStateOf(Uri.EMPTY) }
    var imagePreviewState by remember {
        mutableStateOf(false)
    }


     val multiplePhotoPicker = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia(),
        ) { image ->
            if (image != null) {
                onSelectImage(image)
                imageSelected = image
                imagePreviewState = true
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
        ,
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        ButtonsRow(
            onSaveClicked = onSaveClicked,
            onCancelClicked = onCancelClicked
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .height(250.dp)
                    .padding(all = 8.dp)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.cover_book)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = "Gallery Image"
            )

            Icon(
                imageVector = Icons.Rounded.AddPhotoAlternate,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.surfaceTint,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(40.dp)
                    .clickable {
                        multiplePhotoPicker.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    }
            )
        }


        Spacer(modifier = Modifier.height(20.dp))

        EventDetailsCard(
            eventTitleValue = eventTitleValue,
            onTitleValueChange = onEventValueChange,
            locationValue = locationValue,
            onLocationValueChange = onLocationValueChange,
            eventDate = eventDate,
            onDateValueChange = onDateValueChange,
            eventTime = eventTime,
            onTimeValueChange = onTimeValueChange,
            eventDescription = eventDescription,
            onDescriptionValueChange = onDescriptionValueChange,
            eventLimit = eventLimit,
            onLimitValueChange = onLimitValueChange
        )

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailsCard(
    eventTitleValue: String,
    onTitleValueChange: (String) -> Unit,
    locationValue: String,
    onLocationValueChange: (String) -> Unit,
    eventDate: String,
    onDateValueChange: (String) -> Unit,
    eventTime: String,
    onTimeValueChange: (String) -> Unit,
    eventLimit: String,
    onLimitValueChange: (String) -> Unit,
    eventDescription: String,
    onDescriptionValueChange: (String) -> Unit,
){

    InputTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        value = eventTitleValue,
        leadingIcon = R.drawable.text_t,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface,
            cursorColor = KhoButtonsColors.buttonColor,
            unfocusedIndicatorColor = Color.Unspecified,
            focusedIndicatorColor = Color.Unspecified),
        keyboardType = KeyboardType.Text,
        visualTransformation = VisualTransformation.None,
        placeholder =  R.string.event_title,
        onValueChange = onTitleValueChange
    )

    Spacer(modifier = Modifier.height(20.dp))

    InputTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        value = eventDate,
        leadingIcon = R.drawable.date,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface,
            cursorColor = KhoButtonsColors.buttonColor,
            unfocusedIndicatorColor = Color.Unspecified,
            focusedIndicatorColor = Color.Unspecified),
        keyboardType = KeyboardType.Text,
        visualTransformation = VisualTransformation.None,
        placeholder = R.string.date,
        onValueChange = onDateValueChange
    )

    Spacer(modifier = Modifier.height(20.dp))

    InputTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        value = eventTime,
        leadingIcon = R.drawable.time,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface,
            cursorColor = KhoButtonsColors.buttonColor,
            unfocusedIndicatorColor = Color.Unspecified,
            focusedIndicatorColor = Color.Unspecified),
        keyboardType = KeyboardType.Text,
        visualTransformation = VisualTransformation.None,
        placeholder =  R.string.start_time,
        onValueChange = onTimeValueChange
    )

    Spacer(modifier = Modifier.height(20.dp))

    InputTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        value = locationValue,
        leadingIcon = R.drawable.time,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface,
            cursorColor = KhoButtonsColors.buttonColor,
            unfocusedIndicatorColor = Color.Unspecified,
            focusedIndicatorColor = Color.Unspecified),
        keyboardType = KeyboardType.Text,
        visualTransformation = VisualTransformation.None,
        placeholder =  R.string.end_time,
        onValueChange = onLocationValueChange
    )

    Spacer(modifier = Modifier.height(20.dp))

    InputTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        value = eventDescription,
        leadingIcon = R.drawable.pencil,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface,
            cursorColor = KhoButtonsColors.buttonColor,
            unfocusedIndicatorColor = Color.Unspecified,
            focusedIndicatorColor = Color.Unspecified),
        keyboardType = KeyboardType.Text,
        visualTransformation = VisualTransformation.None,
        placeholder =  R.string.description,
        onValueChange = onDescriptionValueChange
    )

    Spacer(modifier = Modifier.height(20.dp))

    InputTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        value = eventLimit,
        leadingIcon = R.drawable.limit,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface,
            cursorColor = KhoButtonsColors.buttonColor,
            unfocusedIndicatorColor = Color.Unspecified,
            focusedIndicatorColor = Color.Unspecified),
        keyboardType = KeyboardType.Text,
        visualTransformation = VisualTransformation.None,
        placeholder =  R.string.limit,
        onValueChange = onLimitValueChange
    )
}

@Composable
fun ButtonsRow(
    onSaveClicked: () -> Unit,
    onCancelClicked: () -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            modifier = Modifier
                .padding(end = 6.dp)
                .height(45.dp)
                .width(120.dp),
            onClick =onCancelClicked,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = KhoButtonsColors.cancelButtonColor,
                contentColor = KhoButtonsColors.white
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 2.dp
            )
        ) {
            Text(text = "Cencelar")
        }

        Button(
            modifier = Modifier
                .padding(start = 6.dp)
                .height(45.dp)
                .width(120.dp),
            onClick = onSaveClicked,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = KhoButtonsColors.buttonColor,
                contentColor = KhoButtonsColors.white
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 2.dp
            )
        ) {
            Text(text = "Guardar")
        }


    }
}

