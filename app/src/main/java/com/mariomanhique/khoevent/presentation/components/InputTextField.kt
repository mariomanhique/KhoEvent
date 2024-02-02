package com.mariomanhique.khoevent.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    value: String,
    keyboardType: KeyboardType,
    colors: TextFieldColors,
    trailingIcon: ImageVector? = null,
    @DrawableRes leadingIcon: Int? = null,
    iconTint: Color? = null,
    onIconClicked: () -> Unit = {  },
    visualTransformation: VisualTransformation,
    focusDirection: FocusDirection? = null,
    focusManager: FocusManager? = null,
    @StringRes placeholder: Int,
    onValueChange: (String) -> Unit
){

    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        maxLines = 1,

        singleLine = true,
        placeholder = {
            Text(
                text = stringResource(id = placeholder),
                color = Color.Gray
            )
        },
        trailingIcon = {

            trailingIcon?.let {icon->
                iconTint?.let {
                    IconButton(onClick = onIconClicked) {
                        Icon(imageVector = icon,
                            contentDescription = stringResource(id = placeholder),
                            tint = it
                        )
                    }
                }
            }


        },
        leadingIcon = {
            leadingIcon?.let {icon->
//                iconTint?.let {
                    IconButton(onClick = onIconClicked) {
                        Icon(painter = painterResource(id = icon),
                            contentDescription = stringResource(id = placeholder),
//                            tint = it
                        )
                    }
//                }
            }
        }
        ,
        shape = MaterialTheme.shapes.medium,
        colors = colors,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType =keyboardType
        ),
        keyboardActions = KeyboardActions (
            onNext = {
                if (focusDirection != null){
                    focusManager?.moveFocus(focusDirection)
                }
                focusManager?.clearFocus()
            }
        ),
        visualTransformation = visualTransformation
        )
}