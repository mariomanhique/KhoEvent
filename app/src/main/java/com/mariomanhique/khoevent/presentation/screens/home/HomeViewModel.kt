package com.mariomanhique.khoevent.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mariomanhique.khoevent.data.repository.KhoEventsRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: KhoEventsRepoImpl):ViewModel() {


    init {
        getCommunities()
    }
    fun getCommunities(){
        viewModelScope.launch {
            val result = repository.getCommunities()

            Log.d("Communities", "getCommunities: $result ")
        }
    }
}