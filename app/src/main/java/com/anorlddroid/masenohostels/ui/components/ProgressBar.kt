package com.anorlddroid.masenohostels.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anorlddroid.masenohostels.ui.theme.MasenoHostelsTheme

@Composable
fun CircularProgressBar(isDisplayed : Boolean){
    if (isDisplayed){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, bottom = 20.dp, end = 20.dp, start = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                color = MasenoHostelsTheme.colors.brand
            )

        }
    }
}
