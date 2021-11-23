package com.anorlddroid.masenohostels

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.anorlddroid.masenohostels.ui.theme.MasenoHostelsTheme
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsScaffold
import com.google.accompanist.insets.ProvideWindowInsets

@ExperimentalCoilApi
@ExperimentalMaterialApi
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