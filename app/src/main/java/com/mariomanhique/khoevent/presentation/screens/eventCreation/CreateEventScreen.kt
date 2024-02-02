package com.mariomanhique.khoevent.presentation.screens.eventCreation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import com.mariomanhique.khoevent.model.EventRequest
import com.mariomanhique.khoevent.presentation.screens.community.CommunityViewModel

@Composable
fun CreateEventScreen(
    navigateToCommunityEvents: () -> Unit,
    communityViewModel: CommunityViewModel = hiltViewModel()
){

    val context = LocalContext.current
    var eventTitle by remember {
        mutableStateOf("")
    }

    var locationValue by remember {
        mutableStateOf("")
    }


    var eventDate by remember {
        mutableStateOf("")
    }
    var eventStartTime by remember {
        mutableStateOf("")
    }
    var eventEndTime by remember {
        mutableStateOf("")
    }

    var eventLimit by remember {
        mutableStateOf("50")
    }

    var eventDescription by remember {
        mutableStateOf("")
    }


    CreateEventContent(
        imageProfile = null,
        eventTitleValue = eventTitle,
        onEventValueChange = {
            eventTitle = it
        },
        locationValue = eventEndTime,
        onLocationValueChange = {
            eventEndTime = it
        },
        eventDate = eventDate,
        onDateValueChange = {
            eventDate = it
        },
        eventTime = eventStartTime,
        onTimeValueChange = {
            eventStartTime =it
        },
        eventLimit = eventLimit,
        onLimitValueChange = {
            eventLimit = it
        },
        eventDescription = eventDescription,
        onDescriptionValueChange = {
                   eventDescription = it
        },
        onSaveClicked = {
            if (eventTitle.isNotEmpty() &&
                eventDate.isNotEmpty() &&
                eventStartTime.isNotEmpty() &&
                eventEndTime.isNotEmpty() &&
                eventLimit.isNotEmpty() &&
                eventDescription.isNotEmpty()

                ){

                val limit = try {
                    eventLimit.toInt()
                }catch (e: Exception){
                  return@CreateEventContent
                }

                if (limit>10){
                    communityViewModel.createEvent(
                        eventRequest = EventRequest(
                            title = eventTitle,
                            description = eventDescription,
                            date = eventDate,
                            startTime = eventStartTime,
                            endTime = eventEndTime,
                            eventLimit = limit
                        ),
                        onSuccess = {
                            navigateToCommunityEvents()
                        },
                        onFailure = {

                        },
                    )
                }else{
                    Toast.makeText(context, "O limite tem que ser um numero",Toast.LENGTH_SHORT).show()
                }

            }

        },
        onCancelClicked = navigateToCommunityEvents,
        onSelectImage = {}


    )
}