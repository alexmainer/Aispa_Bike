package com.mit.avispabikehireapplication.ui.theme.screen.register


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mit.avispabikehireapplication.R
import com.mit.avispabikehireapplication.data.AuthViewModel
import com.mit.avispabikehireapplication.navigation.ROUTE_LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(controller:NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confpass by remember { mutableStateOf(TextFieldValue("")) }
    val context= LocalContext.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(
                    rememberScrollState()
                ),
            horizontalAlignment = Alignment.CenterHorizontally,

            )
        {
            Text(
                text = "REGISTER",
                color = Color(0xFFFF9800),
                fontFamily = FontFamily.Monospace,
                fontSize = 40.sp
            )

            Spacer(modifier = Modifier.height(15.dp))

            Image(
                painter = painterResource(id = R.drawable.or_1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        color = Color(0xFFFF9800),
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.height(57.dp))


            OutlinedTextField(
                value = email,
                label = { Text(text = "Enter Email Address", color = Color(0xFFFF9800)) },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onValueChange = {
                    email = it
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black, // Set text color to black
                    focusedBorderColor = Color.Black, // Change border color when focused
                    unfocusedBorderColor = Color.Gray, // Change border color when not focused
                    cursorColor = Color(0xFFFF9800) // Set cursor color to black
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.background
                    )
                }
            )


            Spacer(modifier = Modifier.height(10.dp))


            OutlinedTextField(
                value = pass,
                label = { Text(text = "Enter Password", color = Color(0xFFFF9800)) },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onValueChange = {
                    pass = it
                },

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black, // Set text color to black
                    focusedBorderColor = Color.Black, // Change border color when focused
                    unfocusedBorderColor = Color.Gray, // Change border color when not focused
                    cursorColor = Color(0xFFFF9800) // Set cursor color to black
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.background
                    )
                }
            )

            Spacer(modifier = Modifier.height(10.dp))


            OutlinedTextField(
                value = confpass,
                label = { Text(text = "Confirm Password ", color = Color(0xFFFF9800)) },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onValueChange = {
                    confpass = it
                },

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black, // Set text color to black
                    focusedBorderColor = Color.Black, // Change border color when focused
                    unfocusedBorderColor = Color.Gray, // Change border color when not focused
                    cursorColor = Color(0xFFFF9800) // Set cursor color to black
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.background
                    )
                }
            )


            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {

                    val myregister = AuthViewModel(controller, context)
                    // myregister.signup(email.text.trim(), pass.text.trim(), confpass.text.trim())
                    myregister.signup(email.text.trim(), pass.text.trim(), confpass.text.trim())

                },
                colors = ButtonDefaults.buttonColors(Color(0xFFFF9800)),
            )
            {
                Text(
                    text = "Register",
                    color = Color.White
                )


            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    controller.navigate(ROUTE_LOGIN)
                },
                //modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            )
            {
                Text(
                    text = "Already have an account? Click to LogIn",
                    color = Color(0xFFFF9800),
                    fontSize = 17.sp
                )


            }
        }
}




@Preview
@Composable
fun RegisterPreview() {
    RegisterScreen(rememberNavController())

}
