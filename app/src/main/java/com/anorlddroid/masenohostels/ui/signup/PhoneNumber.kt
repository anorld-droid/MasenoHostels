package com.anorlddroid.masenohostels.ui.signup

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
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
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

@Composable
fun PhoneNumber(navController : NavController){
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
        Column( modifier = Modifier.padding(top = 100.dp)) {
            var phoneNumber by remember { mutableStateOf("") }
            var errorState by remember { mutableStateOf(false) }
            var errorMessage by remember { mutableStateOf("") }
            val maxLength = 9
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 26.dp, end = 26.dp)
            ) {
                Text(
                    text = "+254",
                    style = MaterialTheme.typography.h5
                )
                TextField(
                    value = phoneNumber,
                    onValueChange = {
                        if (it.length <= maxLength) phoneNumber = it
                        when {
                            phoneNumber.isEmpty() -> {
                                errorState = true
                                errorMessage = "Cannot be empty"
                            }
                            !phoneNumber.isDigitsOnly() -> {
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
                            text = "Enter Your Phone Number",
                            color = MasenoHostelsTheme.colors.textSecondary,
                        )
                    },
                    trailingIcon = {
                        if (phoneNumber.isNotEmpty()) {
                            Icon(
                                Icons.Filled.Clear,
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    phoneNumber = ""
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


            // create instance of firebase auth
            lateinit var auth: FirebaseAuth

            // we will use this to match the sent otp from firebase
            lateinit var storedVerificationId: String
            lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
            lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

            auth = FirebaseAuth.getInstance()

            // Callback function for Phone Auth
            callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                // This method is called when the verification is completed
                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    navController.navigate("home/Home")
                    Log.d("MSH", "onVerificationCompleted Success")
                }

                // Called when verification is failed add log statement to see the exception
                override fun onVerificationFailed(e: FirebaseException) {
                    Log.d("MSH", "onVerificationFailed  $e")
                }

                // On code is sent by the firebase this method is called
                // in here we start a new activity where user can enter the OTP
                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {
                    Log.d("GFG", "onCodeSent: $verificationId")
                    storedVerificationId = verificationId
                    resendToken = token

                    // Start a new activity using intent
                    // also send the storedVerificationId using intent
                    // we will use this id to send the otp back to firebase
//            val intent = Intent(applicationContext,OtpActivity::class.java)
//            intent.putExtra("storedVerificationId",storedVerificationId)
//            startActivity(intent)
//            finish()
                    navController.navigate("signup/OtpVerification/$storedVerificationId")

                }
            }
            Row(
                modifier = Modifier.padding(top = 40.dp, start = 100.dp, end = 100.dp)
            ) {
                MasenoHostelsButton(
                    onClick = {
                        val options = PhoneAuthOptions.newBuilder(auth)
                            .setPhoneNumber(phoneNumber) // Phone number to verify
                            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit // Activity (for callback binding)
                            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
                            .build()
                        PhoneAuthProvider.verifyPhoneNumber(options)
                        Log.d("GFG" , "Auth started") }
                ) {
                    Text(
                        text = "Send Code",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(3.dp)
                            .fillMaxWidth()
                    )
                }
            }

            Text(
                text = "Note that sms or data rate charges may apply",
                modifier = Modifier.padding(top = 20.dp)
            )


        }
    }
}

