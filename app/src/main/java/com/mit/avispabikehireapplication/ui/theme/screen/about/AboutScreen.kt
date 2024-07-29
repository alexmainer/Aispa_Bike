package com.mit.avispabikehireapplication.ui.theme.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mit.avispabikehireapplication.R
import com.mit.avispabikehireapplication.navigation.ROUTE_ABOUT
import com.mit.avispabikehireapplication.navigation.ROUTE_CONTACT_US
import com.mit.avispabikehireapplication.navigation.ROUTE_DETAILS
import com.mit.avispabikehireapplication.navigation.ROUTE_HOME
import com.mit.avispabikehireapplication.ui.theme.screen.home.NavigationItem
import com.mit.avispabikehireapplication.ui.theme.screen.index.IndexScreen

@androidx.compose.runtime.Composable
fun AboutScreen(controller: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
            .verticalScroll(rememberScrollState()
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
       //Spacer(modifier = Modifier.height(19.dp))
        Surface(
            color= Color.Transparent,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.White) // Background color of the card
                    .clickable { /* Handle card click if needed */ }
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    NavigationItem(
                        text = "HOME",
                        route = ROUTE_HOME,
                        controller = controller
                    )

                    NavigationItem(
                        text = "ABOUT US",
                        route = ROUTE_ABOUT,
                        controller = controller
                    )

                    NavigationItem(
                        text = "CONTACT US",
                        route = ROUTE_CONTACT_US,
                        controller = controller
                    )

                    NavigationItem(
                        text = "RECEIPTS",
                        route = ROUTE_DETAILS,
                        controller = controller
                    )
                }
            }
        }

        Text(
            text = "ABOUT US",
            color = Color(0xFF7700FF),
            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.front),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color(0xFF000000))
                .border(
                    width = 5.dp,
                    color = Color(0xFF7700FF),
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.height(30.dp))


        Text(
            text = "Welcome to Avispa Bike Hire Company! We are passionate about providing exceptional bike rental services to enhance your cycling experience in the beautiful" +
                    " landscapes of Wakanda. Our mission is to promote an active and sustainable lifestyle while exploring the wonders on two wheels.",
            color = Color(0xFF070707),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Functions" ,
            color = Color(0xFF7700FF),
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = " 1. Quality Bike Rentals " ,
            color = Color(0xFF000000),
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text =
                    "At Avispa Bike Hire Company, we offer a wide range of greatly maintained bicycles suitable for different preferences and riding styles." +
                    " Whether you're into leisurely rides, mountain adventures, or road cycling escapades, we have the perfect bike for you.\n"
                    ,
            color = Color(0xFF000000),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )
        Text(
            text = " 2. Guided Tours and Routes" ,
            color = Color(0xFF000000),
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = " Discover the hidden gems of Wakanda with our curated guided tours and recommended cycling routes. Our experienced team can provide insights," +
                    "safety tips, and local knowledge to make your cycling journey memorable and enjoyable.\" " ,
            color = Color(0xFF000000),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp,

        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Mission" ,
            color = Color(0xFF7700FF),
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text =
                    "Our mission at Avispa Bike Hire Company is to empower people to embrace an active lifestyle by providing access to high-quality bicycles and exceptional" +
                    "cycling experiences. We believe in fostering a sense of adventure, promoting sustainable travel, and encouraging a strong connection with the environment " +
                    "through cycling.",
            color = Color(0xFF070707),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Location" ,
            color = Color(0xFF7700FF),
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text =
                    "Avispa Bike Hire Company is nestled in the heart of Wakanda, a region renowned for its stunning natural beauty and diverse cycling trails. " +
                    "Our strategic location allows easy access scenic routes, varying in difficulty and terrain, ensuring there's a perfect ride for everyone," +
                    " from beginners to avid cyclists.",
            color = Color(0xFF070707),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "RIDE WITH AVISPA: WHERE WHEELS MEET WONDERS",
            color = Color(0xFF7700FF),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )


    }

}
@Composable
private fun NavigationItem(text: String, route: String, controller: NavHostController) {
    Text(
        text = text,
        color = Color(0xFFFF9800),
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                controller.navigate(route)
            }
    )
}
@Preview
@Composable
fun AboutPreview() {
    AboutScreen(rememberNavController())

}