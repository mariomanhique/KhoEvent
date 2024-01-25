package com.mariomanhique.khoevent.presentation.screens.auth.signIn

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mariomanhique.khoevent.presentation.screens.auth.AuthViewModel
import com.mariomanhique.khoevent.presentation.screens.auth.signIn.SignInContent

@Composable
fun SignInScreen(
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,
//    onShowSnackbar: suspend (String, String?) -> Boolean,
    authViewModel: AuthViewModel = hiltViewModel()
){
    val loadingState by authViewModel.loadingState
    val authUiState by authViewModel.authUiState.collectAsStateWithLifecycle()



    SignInContent(
        onSignInClicked = { email, password->
            authViewModel.signIn(
                email = email,
                password = password,
                onSuccess = {
                    navigateToHome()
                },
                onFailure = {

                }
            )

        },
        navigateToSignUp = navigateToSignUp
    )

    if (loadingState){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

}