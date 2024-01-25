package com.mariomanhique.khoevent.presentation.screens.auth

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mariomanhique.khoevent.data.repository.userDataRepository.UserDataRepository
import com.mariomanhique.khoevent.data.repository.KhoEventsRepoImpl
import com.mariomanhique.khoevent.utils.Constants.EMAIL_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: KhoEventsRepoImpl,
    private val userDataRepository: UserDataRepository,
    private val savedStateHandle: SavedStateHandle,
    ): ViewModel(){

    var loadingState = mutableStateOf(false)
    var authUiState: StateFlow<AuthUiState> = MutableStateFlow<AuthUiState>(AuthUiState.Loading)

//    init {
//
//        userDataRepository.userData.map {
//            savedStateHandle[ACCESS_TOKEN] = it.accessToken
//        }
//
//    }
    fun signIn(
        email: String,
        password: String,
        onSuccess: ()-> Unit,
        onFailure: ()-> Unit,
    ){
        viewModelScope.launch {
            val accessToken = repository.authenticateUser(email, password)
            if (accessToken != null) {
                userDataRepository.setAccessToken(accessToken = accessToken)
                userDataRepository.setCommunityEmail(email = email)
                    Log.d("Auth", "signIn: $accessToken")
                    onSuccess()
                }else{
                    onFailure()
                }
            }
    }

    fun signUp(
        email: String,
        communityName: String,
        password: String,
        repeatedPassword: String,
        onSuccess: ()-> Unit,
        onFailure: ()-> Unit,
    ){
        onSuccess()
    }


}

sealed interface AuthUiState{
    data object Loading: AuthUiState
    data class Error(var error: Throwable): AuthUiState
    data class Success(var data: Boolean): AuthUiState
}