package com.mit.avispabikehireapplication.ui.theme.screen.contact

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mit.avispabikehireapplication.R
import com.mit.avispabikehireapplication.navigation.ROUTE_ABOUT
import com.mit.avispabikehireapplication.navigation.ROUTE_CONTACT_US
import com.mit.avispabikehireapplication.navigation.ROUTE_DETAILS
import com.mit.avispabikehireapplication.navigation.ROUTE_HOME
import com.mit.avispabikehireapplication.ui.theme.screen.home.NavigationItem


@Composable
fun ContactScreen(controller: NavHostController) {
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
            text = "CONTACT US",
            color = Color(0xFFFF9800),
            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.la),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(
                    width = 5.dp,
                    color = Color.Black,
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "We value your inquiries and feedback. Feel free to reach out to us using any of the following methods:",
            color = Color(0xFF070707),
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Contact Information",
            color = Color(0xFF070707),
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Physical Address:\n" +
                    " Tchalla Street, Suite 101, Kalakuta, \n" +
                    "\n" +
                    "Phone Number:\n" +
                    "+254-715-789-670\n" +
                    "\n" +
                    "Email Address:\n" +
                    "info@avispabikehire.com",
            color = Color(0xFF070707),
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp
        )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Social Media",
                color = Color(0xFF070707),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Stay connected with us on social media:",
                color = Color(0xFF070707),
                modifier = Modifier.padding(11.dp),
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                // Profile picture icon

                Image(
                    painterResource(id = R.drawable.x),
                    contentDescription = null, // You can add a content description here
                    modifier = Modifier.size(50.dp)
                )
                Image(
                    painterResource(id = R.drawable.insta),
                    contentDescription = null, // You can add a content description here
                    modifier = Modifier.size(50.dp)
                )
                Image(
                    painterResource(id = R.drawable.facebook),
                    contentDescription = null, // You can add a content description here
                    modifier = Modifier.size(50.dp)
                )
                Image(
                    painterResource(id = R.drawable.app),
                    contentDescription = null, // You can add a content description here
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Map and Directions",
                color = Color(0xFF070707),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.capture),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(
                        width = 5.dp,
                        color = Color.Black,
                        shape = CircleShape
                    )
            )



            Text(
                text = "Operating Hours",
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF070707),
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Monday to Friday:\n" +
                        "9:00 AM - 6:00 PM\n" +
                        "\n" +
                        "Saturday and Sunday:\n" +
                        "10:00 AM - 4:00 PM",
                color = Color(0xFF070707),
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))



    }
}






@Preview
@Composable
fun ContactScreenPreview() {
    ContactScreen(rememberNavController())

}