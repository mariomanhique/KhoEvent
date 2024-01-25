package com.mariomanhique.khoevent

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mariomanhique.khoevent.ui.KhoApp
import com.mariomanhique.khoevent.ui.theme.KhoEventTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import com.mariomanhique.khoevent.MainActivityUiState.Success
import com.mariomanhique.khoevent.MainActivityUiState.Loading

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val viewModel: MainActivityViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window,false)

        var uiState: MainActivityUiState by mutableStateOf(Loading)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach {
                        uiState = it
                    }.collect()
            }
        }


        setContent {
            Toast.makeText(this, checkAccessToken(uiState = uiState),Toast.LENGTH_LONG).show()
            Log.d("Token", "onCreate: ${checkAccessToken(uiState)}")

            KhoEventTheme {
                KhoApp(
                    windowSizeClass = calculateWindowSizeClass(activity = this),
                    accessToken = checkAccessToken(uiState = uiState)
                )
            }
        }
    }
}



fun checkAccessToken(
    uiState: MainActivityUiState
): String {
    return when(uiState){
        Loading ->"Loading"
        is Success -> uiState.userData.accessToken

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KhoEventTheme {
        Greeting("Android")
    }
}