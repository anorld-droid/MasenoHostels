package com.anorlddroid.masenohostels.ui.signup

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.anorlddroid.masenohostels.ui.theme.AlphaNearOpaque
import com.anorlddroid.masenohostels.ui.theme.MasenoHostelsTheme
import com.anorlddroid.masenohostels.ui.theme.Rose4
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsButton
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsDivider
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsScaffold
import com.google.accompanist.insets.statusBarsPadding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

@Composable
fun OtpVerification(navController: NavController, storedVerificationId: String?) {
    MasenoHostelsScaffold(
        topBar = {
            Column(modifier = Modifier.statusBarsPadding())
            {
                TopAppBar(
                    modifier = Modifier,
                    backgroundColor = MasenoHostelsTheme.colors.uiBackground.copy(alpha = AlphaNearOpaque),
                    contentColor = MasenoHostelsTheme.colors.textSecondary,
                    elevation = 0.dp, // No shadow needed
                    title = {
                        Text(
                            text = "OTP Verification",
                            style = MaterialTheme.typography.h4,
                            color = MasenoHostelsTheme.colors.textHelp,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(1f)
                                .align(Alignment.CenterHorizontally)
                        )
                    }
                )
                MasenoHostelsDivider(thickness = 1.dp)
            }

        }
    ) {
        Column(modifier = Modifier.padding(top = 100.dp)) {
            var verificationCode by remember { mutableStateOf("") }
            var errorState by remember { mutableStateOf(false) }
            var errorMessage by remember { mutableStateOf("") }
            val maxLength = 9
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 26.dp, end = 26.dp)
            ) {
                TextField(
                    value = verificationCode,
                    onValueChange = {
                        if (it.length <= maxLength) verificationCode = it
                        when {
                            verificationCode.isEmpty() -> {
                                errorState = true
                                errorMessage = "Cannot be empty"
                            }
                            !verificationCode.isDigitsOnly() -> {
                                errorState = true
                                errorMessage = "Only Digits are allowed"
                            }
                        }
                    },
                    singleLine = true,
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .fillMaxWidth(),
                    textStyle = MaterialTheme.typography.h6,
                    placeholder = {
                        Text(
                            text = "Verification Code",
                            color = MasenoHostelsTheme.colors.textSecondary,
                        )
                    },
                    trailingIcon = {
                        if (verificationCode.isNotEmpty()) {
                            Icon(
                                Icons.Filled.Clear,
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    verificationCode = ""
                                }
                            )
                        }

                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MasenoHostelsTheme.colors.uiBackground,
                        cursorColor = MasenoHostelsTheme.colors.textSecondary,
                        errorCursorColor = MasenoHostelsTheme.colors.error,
                        disabledLabelColor = MasenoHostelsTheme.colors.uiFloated,
                        focusedIndicatorColor = Rose4,
                        unfocusedIndicatorColor = Color.Transparent,
                        trailingIconColor = Rose4,
                        errorTrailingIconColor = MasenoHostelsTheme.colors.error,
                        errorIndicatorColor = MasenoHostelsTheme.colors.error,

                        ),
                    shape = RectangleShape,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                if (errorState) {
                    Text(
                        text = errorMessage,
                        modifier = Modifier
                            .padding(start = 12.dp, bottom = 4.dp)
                            .fillMaxWidth(),
                        color = MasenoHostelsTheme.colors.error
                    )
                }
            }

            val context = LocalContext.current

            // get reference of the firebase auth
            lateinit var auth: FirebaseAuth
            auth = FirebaseAuth.getInstance()
            // get storedVerificationId
            // fill otp and call the on click on button

            Row(
                modifier = Modifier.padding(top = 40.dp, start = 100.dp, end = 100.dp)
            ) {
                MasenoHostelsButton(
                    onClick = {
                        val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(
                            storedVerificationId.toString(), verificationCode
                        )
                        auth.signInWithCredential(credential)
                            .addOnCompleteListener() { task ->
                                if (task.isSuccessful) {
                                    navController.navigate("home/Home")
                                } else {
                                    // Sign in failed, display a message and update the UI
                                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                                        // The verification code entered was invalid
                                        Toast.makeText(context,"Invalid OTP", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                    }
                ) {
                    Text(
                        text = "Verify",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(3.dp)
                            .fillMaxWidth()
                    )
                }
            }

        }
    }
}

private fun signInWithPhoneAuthCredential(
    credential: PhoneAuthCredential,
    navController: NavController,

) {

}