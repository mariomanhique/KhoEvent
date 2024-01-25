package com.mariomanhique.khoevent.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mariomanhique.khoevent.data.repository.KhoEventsRepoImpl
import com.mariomanhique.khoevent.model.Communities
import com.mariomanhique.khoevent.model.Event
import com.mariomanhique.khoevent.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: KhoEventsRepoImpl):ViewModel() {

    private var _data: MutableStateFlow<Result<Communities>> = MutableStateFlow(Result.Idle)
    private var _events: MutableState<Result<List<Event>>> = mutableStateOf(Result.Idle)
    val  events = _events
    val data = _data.asStateFlow()

    init {
        getCommunities()
        getEvents()
    }
    fun getCommunities(){
        viewModelScope.launch {
            _data.value = Result.Loading
            val result = repository.getCommunities()
            if (result.isNotEmpty()){
                _data.value = Result.Success(data = result)
            }else{
                _data.value = Result.Error()
            }

        }
    }

    fun getEvents(){
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
}