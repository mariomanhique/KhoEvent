package com.mariomanhique.khoevent.presentation.screens.community

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mariomanhique.khoevent.data.repository.KhoEventsRepoImpl
import com.mariomanhique.khoevent.data.repository.userDataRepository.UserDataRepository
import com.mariomanhique.khoevent.model.Communities
import com.mariomanhique.khoevent.model.Event
import com.mariomanhique.khoevent.model.EventRequest
import com.mariomanhique.khoevent.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val repository: KhoEventsRepoImpl,
    private val userDataRepository: UserDataRepository,
):ViewModel() {

    private var _data: MutableStateFlow<Result<Communities>> = MutableStateFlow(Result.Idle)
    private var _events: MutableStateFlow<Result<List<Event>>> = MutableStateFlow(Result.Idle)
    val  events = _events.asStateFlow()
    val data = _data.asStateFlow()

    init {
        createEvent(
           onSuccess =  {},
           onFailure =  {},
        )
        getEvents()
    }

    private fun getEvents(){
        viewModelScope.launch {
            _events.value = Result.Loading
            val result = repository.getEvents()
            if (result.isNotEmpty()){
                _events.value = Result.Success(data = result)
            }else{
                _events.value = Result.Error()
            }
        }
    }

//    fun createEvent(
////        eventRequest: EventRequest,
//        onSuccess: ()-> Unit,
//        onFailure: ()-> Unit,
//    ){
//        viewModelScope.launch {
//            val communityEmail: String = userDataRepository.userData.map {
//                it.communityEmail
//            }.first()
//
//            val filteredCommunity = repository.getCommunities().first {
//                it.email == communityEmail
//            }
//
//            val communityFlow = flowOf{filteredCommunity}
//            val accessToken: Flow<String> = userDataRepository.userData.map {
//                it.accessToken
//            }
//            combine(
//                communityFlow,
//                accessToken,
//                ::Pair,
//            )
//            .map {(community, token)->
//               val result = repository.createEvent(
//                   authorizationHeader = "Bearer $token",
//                    communityId = community.,
//                    eventRequest = EventRequest(
//                        description = "Evento Teste Description",
//                        endTime = "15:00",
//                        eventDate = "2024-02-24",
//                        startTime = "10:00",
//                        title = " Evento Teste",
//                        eventLimit = 20
//                    )
//                )
//
//                if (result == "201"){
//                    onSuccess()
//                }else{
//                    onFailure()
//                }
//
//            }
//        }
//    }

    private fun createEvent(
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        viewModelScope.launch {
            val communityEmail: String = userDataRepository.userData.map {
                it.communityEmail
            }.first()

            val filteredCommunity = repository.getCommunities().first {
                it.email == communityEmail
            }

            val accessToken: String = userDataRepository.userData.map {
                it.accessToken
            }.first()


            Log.d("Test", "createEvent:$accessToken")
            Log.d("Test", "createEvent:$communityEmail")
            Log.d("Test", "createEvent:${filteredCommunity.id}")

            val result = repository.createEvent(
                authorizationHeader = "Bearer $accessToken",
                communityId = filteredCommunity.id.toLong(),
                eventRequest = EventRequest(
                    description = "Evento Teste Description",
                    endTime = "15:00",
                    date = "2024-02-24",
                    startTime = "10:00",
                    title = "Evento Teste",
                    eventLimit = 20,
                )
            )

            if (result == HttpURLConnection.HTTP_CREATED.toString()) {
                onSuccess()
            } else {
                onFailure()
            }
        }
    }

}
