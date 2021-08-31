package com.anorlddroid.masenohostels

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.anorlddroid.masenohostels.ui.signup.SignUpScreen
import com.anorlddroid.masenohostels.ui.theme.MasenoHostelsTheme
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsScaffold
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun MasenoHostelsApp() {
    ProvideWindowInsets {
        MasenoHostelsTheme {
            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()
            MasenoHostelsScaffold(
                scaffoldState = scaffoldState,
                ){
               MasenoHostelsNavGraph(
                   navController = navController,
                   scaffoldState = scaffoldState,
                   coroutineScope = coroutineScope
               )
            }
        }
    }
}