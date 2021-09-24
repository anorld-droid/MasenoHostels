package com.anorlddroid.masenohostels.ui.signup


import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.anorlddroid.masenohostels.ui.components.CircularProgressBar
import com.anorlddroid.masenohostels.ui.theme.AlphaNearOpaque
import com.anorlddroid.masenohostels.ui.theme.MasenoHostelsTheme
import com.anorlddroid.masenohostels.ui.theme.Ocean10
import com.anorlddroid.masenohostels.ui.theme.Ocean8
import com.anorlddroid.tweetheart.ui.components.MasenoHostelsButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.HashMap

@Composable
fun SignUpScreen(
    navController: NavController,
){
    LazyColumn(){
        item {
            SignUpContent(
                navController = navController,
            )
        }
    }
}
@Composable
fun SignUpContent(
    navController: NavController,
) {
    var isDisaplyed by remember { mutableStateOf(false)}
    Box{

        Column(
            modifier = Modifier
                .padding(top = 150.dp, start = 10.dp, end = 10.dp)
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
                    text = "Sign Up",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(8.dp)
                )
            }

            var username by remember { mutableStateOf("") }
            var phoneNumber by remember { mutableStateOf("") }
            var idNumber by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }

            Column {
                val maxLength = 18
                var errorState by remember { mutableStateOf(false) }
                var errorMessage by remember { mutableStateOf("") }

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
                        when {
                            username.isEmpty() -> {
                                errorState = true
                                errorMessage = "Cannot be empty"
                            }
                            username.startsWith('_') -> {
                                errorState = true
                                errorMessage = "Cannot Start with _"
                            }
                            username.startsWith('@') -> {
                                errorState = true
                                errorMessage = "Cannot Start with @"
                            }
                            username.startsWith('#') -> {
                                errorState = true
                                errorMessage = "Cannot Start with #"
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
                    isError = errorState,
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
                if (errorState){
                    Text (
                        text = errorMessage,
                        modifier = Modifier
                            .padding(start = 12.dp, bottom = 4.dp)
                            .fillMaxWidth(),
                        color =  MasenoHostelsTheme.colors.error
                    )
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Column {
                var errorState by remember { mutableStateOf(false) }
                var errorMessage by remember { mutableStateOf("") }
                val maxLength = 13

                Text(
                    text = "Phone Number",
                    modifier = Modifier
                        .padding(start = 12.dp, bottom = 4.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h5,
                    color = MasenoHostelsTheme.colors.textSecondary,
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
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = null,
                            tint = MasenoHostelsTheme.colors.textSecondary,
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
                    isError = errorState,
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
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.padding(top = 10.dp)) {
                val maxLength = 16
                var errorState by remember { mutableStateOf(false) }
                var errorMessage by remember { mutableStateOf("") }
                Text(
                    text = "ID Number",
                    modifier = Modifier
                        .padding(start = 12.dp, bottom = 4.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h5,
                    color = MasenoHostelsTheme.colors.textSecondary,
                )
                TextField(
                    value = idNumber,
                    onValueChange = {
                        if (it.length <= maxLength) idNumber = it
                        when {
                            idNumber.isEmpty() -> {
                                errorState = true
                                errorMessage = "Cannot be empty"
                            }
                            !idNumber.isDigitsOnly() -> {
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
                            text = "Enter Your National Id Number",
                            color = MasenoHostelsTheme.colors.textSecondary,
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.AccountBox,
                            contentDescription = null,
                            tint = MasenoHostelsTheme.colors.textSecondary,
                        )
                    },
                    trailingIcon = {
                        if (idNumber.isNotEmpty()) {
                            Icon(
                                Icons.Filled.Clear,
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    idNumber = ""
                                }
                            )
                        }
                    },
                    isError = errorState,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MasenoHostelsTheme.colors.uiFloated,
                        cursorColor = MasenoHostelsTheme.colors.textSecondary,
                        errorCursorColor = MasenoHostelsTheme.colors.textSecondary,
                        disabledLabelColor = MasenoHostelsTheme.colors.uiFloated,
                        focusedIndicatorColor = Color.Transparent,
                        errorTrailingIconColor =  MasenoHostelsTheme.colors.error,
                        errorIndicatorColor =  MasenoHostelsTheme.colors.error,
                        unfocusedIndicatorColor = Color.Transparent,
                        trailingIconColor = MasenoHostelsTheme.colors.textSecondary


                    ),
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

                )
                if (errorState){
                    Text (
                        text = errorMessage,
                        modifier = Modifier
                            .padding(start = 12.dp, bottom = 4.dp)
                            .fillMaxWidth(),
                        color =  MasenoHostelsTheme.colors.error
                    )
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.padding(top = 10.dp)) {
                val maxLength = 13
                var passwordVisiblity by remember { mutableStateOf(false) }
                var errorState by remember { mutableStateOf(false) }
                var errorMessage by remember { mutableStateOf("") }
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
                        when {
                            password.isEmpty() -> {
                                errorState = true
                                errorMessage = "Cannot be empty"
                            }
                            (password.length < 6) -> {
                                errorState = true
                                errorMessage = "Should be atleast 6 characters long"
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
                    isError = errorState,
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
                if (errorState){
                    Text (
                        text = errorMessage,
                        modifier = Modifier
                            .padding(start = 12.dp, bottom = 4.dp)
                            .fillMaxWidth(),
                        color = MasenoHostelsTheme.colors.error
                    )
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.padding(top = 10.dp)) {
                val maxLength = 13
                var passwordVisiblity by remember { mutableStateOf(false) }
                var errorState by remember { mutableStateOf(false) }
                var errorMessage by remember { mutableStateOf("") }
                Text(
                    text = "Confirm Password",
                    modifier = Modifier
                        .padding(start = 12.dp, bottom = 4.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h5,
                    color = MasenoHostelsTheme.colors.textSecondary,
                )
                TextField(
                    value = confirmPassword,
                    onValueChange = {
                        if (it.length <= maxLength) confirmPassword = it
                        when {
                            confirmPassword != password -> {
                                errorState = true
                                errorMessage = "Password does not match"
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
                            text = "Confirm Your Password",
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
                        if (confirmPassword.isNotEmpty()) {
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
                    isError = errorState,
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
                if (errorState){
                    Text (
                        text = errorMessage,
                        modifier = Modifier
                            .padding(start = 12.dp, bottom = 4.dp)
                            .fillMaxWidth(),
                        color = MasenoHostelsTheme.colors.error
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            val validation = validateSignupCredetials(
                username = username,
                idNumber = idNumber,
                password = password,
                confirmPassword = confirmPassword,
            )
            val context = LocalContext.current
            Column(modifier = Modifier.padding(24.dp)) {
                MasenoHostelsButton(
                    onClick = {
                        if (validation == null) {
                            isDisaplyed = true
                            postDataUsingVolley(
                                username = username,
                                phone = phoneNumber,
                                identification = idNumber,
                                password = password,
                                context = context
                            )
                            isDisaplyed = false
                            navController.navigate("home/Home") {
                                launchSingleTop = true
                            }
                        } else{
                            Toast.makeText(context, validation, Toast.LENGTH_LONG).show()
                        }
                    },
                ) {
                    Text(
                        text = "CREATE ACCOUNT",
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
                        text = "Already have an account? ",
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                    TextButton(
                        onClick = {
                            navController.navigate("signin/SignIn") {
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo("signup/SignUp") {
                                        inclusive = true
                                    }
                             }
                        }
                    ) {
                        Text(
                            text = "Sign In ",
                            color = Ocean10,
                            maxLines = 1
                        )
                    }

                }
            }
        }
        CircularProgressBar(isDisplayed = isDisaplyed)
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
fun validateSignupCredetials(
    username: String,
    idNumber: String,
    password: String,
    confirmPassword : String,
) : String? {
    var errorText : String? = null
    if (username.isEmpty() || idNumber.isEmpty() ||
        password.isEmpty() || confirmPassword.isEmpty()
    ){
        errorText = "Cannot have an empty field."
        return errorText
    }
    if (username.startsWith("_") || username.startsWith("@" )
        || username.startsWith("#")){
            errorText= "Invalid Username"
        return errorText
    }
    if (!idNumber.isDigitsOnly()){
        errorText= "ID Number should contain digits only"
        return errorText
    }
    if (password != confirmPassword){
       errorText= "Passwords do not match"
        return errorText
    }

    return errorText
}

private fun postDataUsingVolley(
    username: String,
    phone: String,
    identification: String,
    password: String,
    context: Context
) {

    // our django endpoint
    val url = " http://7f20-41-81-94-210.ngrok.io/register"

    // creating a new variable for our request queue
    val queue = Volley.newRequestQueue(context)

    // on below line we are calling a string
    // request method to post the data to our API
    // in this we are calling a post method.
    val request: StringRequest = object : StringRequest(
        Method.POST, url,
        Response.Listener {
            // inside on response method we are
            // hiding our progress bar
            // and setting data to edit text as empty



            // on below line we are displaying a success toast message.
            Toast.makeText(context, "Data added to API", Toast.LENGTH_SHORT).show()
            //                try {
            //                    // on below line we are passing our response
            //                    // to json object to extract data from it.
            //                    JSONObject respObj = new JSONObject(response);
            //
            //                    // below are the strings which we
            //                    // extract from our json object.
            //                    String name = respObj.getString("username");
            //                    String job = respObj.getString("phone");
            //
            //                    // on below line we are setting this string s to our text view.
            //                    responseTV.setText("Name : " + name + "\n" + "Job : " + job);
            //                } catch (JSONException e) {
            //                    e.printStackTrace();
            //                }
        },
        Response.ErrorListener { error -> // method to handle errors.
            Toast.makeText(context, "Error = $error", Toast.LENGTH_SHORT).show()
            Log.d("FAILURE", "$error")
        }) {
        override fun getParams(): Map<String, String>? {
            // below line we are creating a map for
            // storing our values in key and value pair.
            val params: MutableMap<String, String> = HashMap()

            // on below line we are passing our key
            // and value pair to our parameters.
            params["username"] = username
            params["phone"] = phone
            params["identification"] = identification
            params["password"] = password

            // at last we are
            // returning our params.
            return params
        }
    }
    // below line is to make
    // a json object request.
    queue.add(request)
}