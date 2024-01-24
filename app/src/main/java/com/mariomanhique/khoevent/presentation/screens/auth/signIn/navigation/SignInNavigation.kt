package com.mariomanhique.khoevent.presentation.screens.auth.signIn.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mariomanhique.khoevent.presentation.screens.auth.signIn.SignInScreen

const val signInRoute = "signIn_route"

fun NavController.navigateToSignIn(){
    navigate(signInRoute){
        popUpTo(signInRoute){
            inclusive = true
        }
    }
}

fun NavGraphBuilder.signInRoute(
    navigateToHome: () -> Unit,
    navigateToSignUp: () -> Unit,

){
    composable(signInRoute){
        SignInScreen(
            navigateToHome = navigateToHome,
            navigateToSignUp = navigateToSignUp
        )
    }
}