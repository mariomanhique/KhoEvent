package com.mariomanhique.khoevent.presentation.screens.auth.signUp

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mariomanhique.khoevent.R
import com.mariomanhique.khoevent.presentation.components.AuthTextEvents
import com.mariomanhique.khoevent.presentation.components.InputTextField
import com.mariomanhique.khoevent.presentation.components.KhoButton
import com.mariomanhique.khoevent.presentation.components.KhoIcon
import com.mariomanhique.khoevent.utils.KhoButtonsColors
import com.mariomanhique.khoevent.utils.fontFamily

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SignUpContent(
    onSignUpClicked: (String, String, String, String) -> Unit,
    navigateToSignIn: () -> Unit
){

    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var password by remember {
        mutableStateOf("")
    }

    var repeatedPassword by remember {
        mutableStateOf("")
    }


    var communityName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    var buttonEnabled by remember {
        mutableStateOf(false)
    }

    val signInRequirements = listOf(communityName,password, email, repeatedPassword)
    val signUpRememberedRequirements = remember(signInRequirements) {
        signInRequirements
    }

    LaunchedEffect(signUpRememberedRequirements){
        val result = signUpRememberedRequirements.filter { it.isNotEmpty() }
        buttonEnabled = result.size == 4
    }

    Column {

        Spacer(modifier = Modifier.height(30.dp))

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "",
                modifier = Modifier.size(30.dp)
            )
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        KhoIcon()

//        Text(
//            modifier = Modifier
//                .align(Alignment.Start)
//                .paddingFromBaseline(top = 70.dp, bottom = 20.dp),
//            text = "Cadastro",
//            fontFamily =  fontFamily(
//                fontWeight = FontWeight.Bold
//            ),
//            fontSize = 25.sp
//        )

        InputTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            value = communityName,
            onValueChange = {
                communityName = it
            },
            leadingIcon = R.drawable.profile,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.inverseOnSurface,
                cursorColor = KhoButtonsColors.buttonColor,
                unfocusedIndicatorColor = Color.Unspecified,
                focusedIndicatorColor = Color.Unspecified),
            placeholder = R.string.community,
            focusManager = focusManager,
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None
        )

        Spacer(modifier = Modifier.height(10.dp))


        InputTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            value = email,
            onValueChange = {
                email = it
            },
            leadingIcon = R.drawable.email,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.inverseOnSurface,
                cursorColor = KhoButtonsColors.buttonColor,
                unfocusedIndicatorColor = Color.Unspecified,
                focusedIndicatorColor = Color.Unspecified),
            placeholder = R.string.username,
            focusManager = focusManager,
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None
        )

        Spacer(modifier = Modifier.height(10.dp))


        InputTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            value = password,
            onValueChange = {
                password = it
            },
            leadingIcon = R.drawable.lock,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.inverseOnSurface,
                cursorColor = KhoButtonsColors.buttonColor,
                unfocusedIndicatorColor = Color.Unspecified,
                focusedIndicatorColor = Color.Unspecified),
            placeholder = R.string.password,
            trailingIcon = Icons.Default.RemoveRedEye,
            iconTint = if(passwordVisibility)
                MaterialTheme.colorScheme.secondary
            else MaterialTheme.colorScheme.secondaryContainer,
            onIconClicked = {
                passwordVisibility = !passwordVisibility
            },
            focusManager = focusManager,
            keyboardType = KeyboardType.Password,
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(10.dp))
        InputTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            value = repeatedPassword,
            onValueChange = {
                repeatedPassword = it
            },
            leadingIcon = R.drawable.lock,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.inverseOnSurface,
                cursorColor = KhoButtonsColors.buttonColor,
                unfocusedIndicatorColor = Color.Unspecified,
                focusedIndicatorColor = Color.Unspecified),
            placeholder = R.string.confirm_password,
            trailingIcon = Icons.Default.RemoveRedEye,
            iconTint = if(passwordVisibility)
                MaterialTheme.colorScheme.secondary
            else MaterialTheme.colorScheme.secondaryContainer,
            onIconClicked = {
                passwordVisibility = !passwordVisibility
            },
            focusManager = focusManager,
            keyboardType = KeyboardType.Password,
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(20.dp))

        KhoButton(
            modifier = Modifier.fillMaxWidth(),
            buttonText = R.string.sign_up,
            buttonEnabled = buttonEnabled,
            onClicked = {
                if (communityName.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty() && repeatedPassword.isNotEmpty()){
                    onSignUpClicked(email, communityName, password, repeatedPassword)
                    keyboardController?.hide()
                }else{
                    Toast.makeText(context, "Fields shouldn't be empty", Toast.LENGTH_SHORT).show()
                }
            })

        Spacer(modifier = Modifier.height(10.dp))

        AuthTextEvents(
            authAlternativeText = R.string.sign_in_text,
            authAlternativeTextAction = R.string.sign_In,
            onTextClicked = navigateToSignIn
        )
    }
    }

}