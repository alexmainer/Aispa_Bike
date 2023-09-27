package com.mit.avispabikehireapplication.ui.theme.screen.index

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mit.avispabikehireapplication.R
import com.mit.avispabikehireapplication.data.AuthViewModel
import com.mit.avispabikehireapplication.navigation.ROUTE_BOOKING
import com.mit.avispabikehireapplication.navigation.ROUTE_HOME
import com.mit.avispabikehireapplication.navigation.ROUTE_LOGIN
import com.mit.avispabikehireapplication.navigation.ROUTE_REGISTER
import com.mit.avispabikehireapplication.ui.theme.screen.about.AboutScreen
import com.mit.avispabikehireapplication.ui.theme.screen.register.RegisterScreen

@Composable
fun IndexScreen(controller: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        )
    {
        Spacer(modifier = Modifier.height(19.dp))
        Spacer(modifier = Modifier.height(19.dp))

        Text(
            text = "AVISPA BIKES",
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFF9800),
            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp
        )
        
        Spacer(modifier = Modifier.height(19.dp))
        Spacer(modifier = Modifier.height(19.dp))
        Spacer(modifier = Modifier.height(19.dp))

        Image(
            painter = painterResource(id = R.drawable.la),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape)
                .border(
                    width = 5.dp,
                    color = Color.Black,
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.height(19.dp))
        Spacer(modifier = Modifier.height(19.dp))

        Text(
            text = "Join us at Avispa Bike Company, where passion meets precision, and every pedal stroke takes you closer to your cycling aspirations." +
                    " Embark on a transformative cycling journey with us, and let's ride towards a better, healthier, and more sustainable future.",
            color = Color(0xFF070707),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                      controller.navigate(ROUTE_HOME)

            },
            colors = ButtonDefaults.buttonColors(Color.Black),
        )
        {
            Text(
                text = " WELCOME :)",
                color = Color.White
            )


        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Ride with Avispa: Where Wheels Meet Wonders",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF000000),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )


    }

}
@Preview
@Composable
fun IndexPreview() {
    IndexScreen(rememberNavController())

}