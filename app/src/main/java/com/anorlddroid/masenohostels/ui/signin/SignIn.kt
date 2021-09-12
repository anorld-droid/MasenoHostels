package com.anorlddroid.masenohostels.ui.signin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anorlddroid.masenohostels.ui.theme.AlphaNearOpaque
import com.anorlddroid.masenohostels.ui.theme.MasenoHostelsTheme
import com.anorlddroid.masenohostels.ui.theme.Ocean10
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsButton

@Composable
fun SignInContent(navController: NavController){
    Column(
        modifier = Modifier
            .padding(top = 200.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
            .background(
                color = MasenoHostelsTheme.colors.uiBackground.copy(alpha = AlphaNearOpaque)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Sign In",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp)
            )
        }
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column {
            val maxLength = 18

            Text(
                text = "Username",
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 4.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.h5,
                color = MasenoHostelsTheme.colors.textSecondary,
            )
            TextField(
                value = username,
                onValueChange = {
                    if (it.length <= maxLength) username = it
                },
                singleLine = true,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.h6,
                placeholder = {
                    Text(
                        text = "Enter Your Username",
                        color = MasenoHostelsTheme.colors.textSecondary,
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null,
                        tint = MasenoHostelsTheme.colors.textSecondary,
                    )
                },
                trailingIcon = {
                    if (username.isNotEmpty()) {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                username = ""
                            }
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MasenoHostelsTheme.colors.uiFloated,
                    cursorColor = MasenoHostelsTheme.colors.textSecondary,
                    errorCursorColor = MasenoHostelsTheme.colors.textSecondary,
                    disabledLabelColor = MasenoHostelsTheme.colors.uiFloated,
                    focusedIndicatorColor = Color.Transparent,
                    errorTrailingIconColor =  MasenoHostelsTheme.colors.error,
                    errorIndicatorColor = MasenoHostelsTheme.colors.error,
                    unfocusedIndicatorColor = Color.Transparent,
                    trailingIconColor = MasenoHostelsTheme.colors.textSecondary


                ),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier.padding(top = 10.dp)) {
            val maxLength = 13
            var passwordVisiblity by remember { mutableStateOf(false) }

            Text(
                text = "Password",
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 4.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.h5,
                color = MasenoHostelsTheme.colors.textSecondary,
            )
            TextField(
                value = password,
                onValueChange = {
                    if (it.length <= maxLength) password = it
                },
                singleLine = true,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.h6,
                placeholder = {
                    Text(
                        text = "Enter Your Password",
                        color = MasenoHostelsTheme.colors.textSecondary,
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = null,
                        tint = MasenoHostelsTheme.colors.textSecondary,
                    )
                },
                visualTransformation = if (passwordVisiblity) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    if (password.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                passwordVisiblity = !passwordVisiblity
                            }
                        ) {
                            Icon(
                                imageVector = if (passwordVisiblity)
                                    Icons.Filled.Visibility
                                else Icons.Filled.VisibilityOff,
                                contentDescription = null,
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MasenoHostelsTheme.colors.uiFloated,
                    cursorColor = MasenoHostelsTheme.colors.textSecondary,
                    errorCursorColor = MasenoHostelsTheme.colors.textSecondary,
                    disabledLabelColor = MasenoHostelsTheme.colors.uiFloated,
                    focusedIndicatorColor = Color.Transparent,
                    errorTrailingIconColor = MasenoHostelsTheme.colors.error,
                    errorIndicatorColor = MasenoHostelsTheme.colors.error,
                    unfocusedIndicatorColor = Color.Transparent,
                    trailingIconColor = MasenoHostelsTheme.colors.textSecondary
                ),
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
        Row(modifier = Modifier
            .align(Alignment.End)
        ){
            val openDialog = remember { mutableStateOf(false)}
            TextButton(
                modifier = Modifier
                    .padding(top = 2.dp),
                onClick = { openDialog.value = true }
            ) {
                Text(
                    text = "Forgot password?",
                    color = Ocean10,
                    maxLines = 1
                )
            }
            if (openDialog.value){
                AlertDialog(
                    onDismissRequest = { openDialog.value = false },
                    text = {
                        Text(
                            text = "Functionality not Available",
                            style = MaterialTheme.typography.body2
                        )
                    },
                    confirmButton = {
                        TextButton(onClick = { openDialog.value = false }) {
                            Text(text = "CLOSE")
                        }
                    },
                    backgroundColor = MasenoHostelsTheme.colors.uiFloated,
                    contentColor = MasenoHostelsTheme.colors.textSecondary
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        val context = LocalContext.current
        Column(modifier = Modifier.padding(24.dp)) {
            MasenoHostelsButton(
                onClick = {
                    if (validateLoginCredetials()){
                        navController.navigate("home/Home"){
                            launchSingleTop = true
                            restoreState = true
                            popUpTo("signin/SignIn") {
                                inclusive = true
                            }
                        }
                    }else{
                        Toast.makeText(context, "Invalid Credentials" , Toast.LENGTH_LONG).show()
                    }

                },
            ) {
                Text(
                    text = "Log In ",
                    modifier = Modifier
                        .padding(3.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 20.dp, start = 12.dp, bottom = 12.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "Don't have an account? ",
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
                TextButton(
                    onClick = {
                        navController.navigate("signup/SignUp"){
                            launchSingleTop = true
                            restoreState = true
                            popUpTo("signin/SignIn") {
                                inclusive = true
                            }
                        }
                    }
                ) {
                    Text(
                        text = "Sign Up ",
                        color = Ocean10,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

//Validate credentials return true if the account exists and credentials are correct
fun validateLoginCredetials() : Boolean{
    return true
}
