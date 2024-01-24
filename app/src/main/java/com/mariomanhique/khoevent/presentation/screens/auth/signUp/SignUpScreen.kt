package com.mariomanhique.khoevent.presentation.screens.auth.signUp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mariomanhique.khoevent.presentation.screens.auth.AuthViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun SignUpScreen(
    navigateToSignIn: () -> Unit,
    navigateToHome: () -> Unit,
    authViewModel: AuthViewModel = hiltViewModel()
){

    val loadingState by authViewModel.loadingState

    SignUpContent(
        onSignUpClicked = {email,communityName,password, repeatedPassword->
            authViewModel.signUp(
                email = email,
                password = password,
                communityName = communityName,
                repeatedPassword = repeatedPassword,
                onSuccess = {
                    navigateToHome()
                },
                onFailure = {

                }
            )
        },
        navigateToSignIn = navigateToSignIn
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