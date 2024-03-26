package com.mit.avispabikehireapplication.ui.theme.screen.citybikes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mit.avispabikehireapplication.R
import com.mit.avispabikehireapplication.navigation.ROUTE_ABOUT
import com.mit.avispabikehireapplication.navigation.ROUTE_BOOKING
import com.mit.avispabikehireapplication.navigation.ROUTE_CONTACT_US
import com.mit.avispabikehireapplication.navigation.ROUTE_DETAILS
import com.mit.avispabikehireapplication.navigation.ROUTE_HOME
import com.mit.avispabikehireapplication.ui.theme.screen.home.NavigationItem

@Composable
fun CityBikesScreen(controller: NavHostController) {
    Column(
        modifier= Modifier.background(Color.White)
            .verticalScroll(rememberScrollState()),
    )
    {

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
            text = "CITY BIKES",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = Color(0xFFFF9800),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp,
            letterSpacing = 0.1.em,
            lineHeight = 50.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        HorizontalImageScroll(
            listOf(
                R.drawable.city2,
                R.drawable.city1,
                R.drawable.city
            )
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White) // Background color of the card
        ) {


            Text(
                text = "CITY BIKES ",
                modifier = Modifier.padding(16.dp),
                color = Color(0xFFFF9800),
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp
            )

            Text(
                text = "Explore the heart of the city on our sleek city bikes, designed for urban adventurers like you. Navigate bustling streets, discover hidden gems," +
                        " and enjoy the freedom of a quick, convenient, and eco-friendly ride. ",
                modifier = Modifier.padding(16.dp),
                color = Color(0xFFFFFFFF),
                fontFamily = FontFamily.Serif,
                fontSize = 15.sp
            )

            Text(
                text = "PRICE : KSH 200 per Hour ",
                modifier = Modifier.padding(16.dp),
                color = Color(0xFFFF9800),
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp
            )


            Button(
                onClick = {
                    controller.navigate(ROUTE_BOOKING)

                },
                colors = ButtonDefaults.buttonColors(Color(0xFFFF9800)),
                modifier = Modifier.padding(30.dp)

            )
            {
                Text(
                    text = " BOOK ",
                    color = Color.White
                )

            }
        }

    }

}
@Composable
fun HorizontalImageScroll(imageList: List<Int>) {
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        items(imageList) { imageResId ->
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun CityBikesPreview() {
    CityBikesScreen(rememberNavController())

}