package com.mariomanhique.khoevent.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.mariomanhique.khoevent.navigation.KhoNavHost
import com.mariomanhique.khoevent.presentation.components.NavigationDrawer
import kotlinx.coroutines.launch

@Composable
fun KhoApp(){
    KhoContent()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KhoContent(){
    //User Drawer here and scaffold!
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    NavigationDrawer(
        drawerState = drawerState,
        onSignOutClicked = { /*TODO*/ },
        onDeleteAllClicked = { /*TODO*/ }) {

        Scaffold(
            modifier = Modifier,
            floatingActionButton = {
                //Show for signed users
                FloatingActionButton(
                    modifier = Modifier
                        .padding(4.dp),
                    onClick = {}
                ) {
                    Box(
                        modifier = Modifier
                    ) {
                        Icon(
                            modifier = Modifier,
                            imageVector = Icons.Default.Add,
                            contentDescription = ""
                        )
                    }
                }
            }
        ) {
            KhoNavHost(
                paddingValues = it,
                onMenuClicked = {
                    scope.launch {
                        drawerState.open()
                    }
                }
            )
        }
    }
}