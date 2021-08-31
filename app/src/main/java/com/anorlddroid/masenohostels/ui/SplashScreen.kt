package com.anorlddroid.masenohostels.ui

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anorlddroid.masenohostels.R
import com.anorlddroid.masenohostels.ui.theme.MasenoHostelsTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController : NavController){
    val scale = remember{
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true ){
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 300,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate("signin/SignIn"){
            launchSingleTop = true
            restoreState = true
            popUpTo("SplashScreen") {
                inclusive = true
            }
        }
    }
    Box( contentAlignment = Alignment.Center ,
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Black
            )
    ){
        Image(
            painter = painterResource(id = R.drawable.splash_screen_image),
            contentDescription ="Logo Icon",
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
                .scale(scale.value)
        )
    }
}