package com.anorlddroid.masenohostels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.view.WindowCompat
import coil.annotation.ExperimentalCoilApi

class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MasenoHostelsApp()
        }
    }
}

