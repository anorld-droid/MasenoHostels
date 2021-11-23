package com.anorlddroid.masenohostels

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anorlddroid.masenohostels.ui.home.Home
import com.anorlddroid.masenohostels.ui.signin.SignInContent
import com.anorlddroid.masenohostels.ui.signup.OtpVerification
import com.anorlddroid.masenohostels.ui.signup.PhoneNumber
import com.anorlddroid.masenohostels.ui.signup.SignUpScreen
import kotlinx.coroutines.CoroutineScope

@ExperimentalMaterialApi
@Composable
fun MasenoHostelsNavGraph(
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = "signin/SignIn"
    ){
        composable("signup/SignUp") {
            SignUpScreen(
                navController = navController,
            )
        }
        composable("signin/SignIn") {
            SignInContent(navController = navController)
        }
        composable("signup/PhoneNumber") {
            PhoneNumber(navController = navController)
        }
        composable("signup/OtpVerification/{storedVerificationId}") {
            OtpVerification(navController, it.arguments?.getString("storedVerificationId"))
        }
        composable("home/Home") {
            Home(coroutineScope, scaffoldState = scaffoldState)
        }

    }
}