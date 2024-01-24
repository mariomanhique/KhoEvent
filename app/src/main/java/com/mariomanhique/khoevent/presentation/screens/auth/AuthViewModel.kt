package com.mariomanhique.khoevent.presentation.screens.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class AuthViewModel @Inject constructor(): ViewModel(){

    var loadingState = mutableStateOf(false)
    var authUiState: StateFlow<AuthUiState> = MutableStateFlow<AuthUiState>(AuthUiState.Loading)

    fun signIn(
        email: String,
        password: String,
        onSuccess: ()-> Unit,
        onFailure: ()-> Unit,
    ){
        onSuccess()
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