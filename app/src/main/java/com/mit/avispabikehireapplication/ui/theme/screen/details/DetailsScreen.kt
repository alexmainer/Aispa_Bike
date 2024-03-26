//package com.mit.avispabikehireapplication.ui.theme.screen.details
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateListOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.em
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import com.mit.avispabikehireapplication.data.ProductViewModel
//import com.mit.avispabikehireapplication.model.Product
//
//@Composable
//fun DetailsScreen(controller: NavHostController) {
//
//    Column(modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally) {
//
//        var context = LocalContext.current
//        var productRepository = ProductViewModel(controller, context)
//
//        val emptyProductState = remember { mutableStateOf(Product("","","","","","")) }
//        var emptyProductsListState = remember { mutableStateListOf<Product>() }
//
//        var products = productRepository.viewProducts(emptyProductState, emptyProductsListState)
//
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White)
//            ,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "BOOKING SUCCESSFUL !!",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                color = Color(0xFFFF9800),
//                textAlign = TextAlign.Center,
//                fontFamily = FontFamily.Serif,
//                fontWeight = FontWeight.ExtraBold,
//                fontSize = 40.sp,
//                letterSpacing = 0.1.em,
//                lineHeight = 50.sp
//            )
//
//            //Spacer(modifier = Modifier.height(20.dp))
//
//           LazyColumn(
//           ){
//               items(products){
//                       ProductItem(
//                           name = it.name,
//                           idNumber = it.idNumber,
//                           type = it.selectedBiketype,
//                           quantity = it.quantity,
//                           date = it.date,
//                           id = it.id,
//                           controller = controller ,
//                           productRepository = productRepository
//                       )
//                   }
//
//               }
//
//            }
//        }
//    }
//
//
//@SuppressLint("SimpleDateFormat")
//@Composable
//fun ProductItem(name:String,
//                idNumber:String,
//                type:String,
//                quantity:String,
//                date:String,
//                id:String,
//                controller:NavHostController,
//                productRepository:ProductViewModel) {
//
//    Column(modifier = Modifier.fillMaxWidth()) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//                .background(Color.White) // Background color of the card
//                .clickable { /* Handle card click if needed */ }
//        ) {
//            Text(text = name,
//                modifier = Modifier.padding(8.dp),
//                color = Color(0xFFFFFFFF),
//                fontFamily = FontFamily.Serif,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp
//            )
//            Text(text = idNumber,
//                modifier = Modifier.padding(8.dp),
//                color = Color(0xFFFFFFFF),
//                fontFamily = FontFamily.Serif,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp
//            )
//            Text(text = type,
//                modifier = Modifier.padding(8.dp),
//                color = Color(0xFFFFFFFF),
//                fontFamily = FontFamily.Serif,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp
//            )
//            Text(text = quantity,
//                modifier = Modifier.padding(16.dp),
//                color = Color(0xFFFFFFFF),
//                fontFamily = FontFamily.Serif,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp
//            )
//            Text(text = date,
//                modifier = Modifier.padding(8.dp),
//                color = Color(0xFFFFFFFF),
//                fontFamily = FontFamily.Serif,
//                fontWeight = FontWeight.Bold,
//                fontSize = 20.sp
//            )
//        }
//
//
//    }
//}
//
//
//
//@Preview
//@Composable
//fun DetailsScreenPreview() {
//    DetailsScreen(rememberNavController())
//
//}
//
//

package com.mit.avispabikehireapplication.ui.theme.screen.details

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mit.avispabikehireapplication.data.ProductViewModel
import com.mit.avispabikehireapplication.model.Product
import com.mit.avispabikehireapplication.navigation.ROUTE_ABOUT
import com.mit.avispabikehireapplication.navigation.ROUTE_CONTACT_US
import com.mit.avispabikehireapplication.navigation.ROUTE_DETAILS
import com.mit.avispabikehireapplication.navigation.ROUTE_HOME


@Composable
fun DetailsScreen(controller: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var productRepository = ProductViewModel(controller, context)

        val emptyProductState = remember { mutableStateOf(Product("", "", "", "", "", "")) }
        var emptyProductsListState = remember { mutableStateListOf<Product>() }

        var products = productRepository.viewProducts(emptyProductState, emptyProductsListState)

        Column(
            modifier = Modifier.fillMaxSize().background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

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
                text = "RECEIPT!!",
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                color = Color(0xFFFF9800),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 40.sp,
                letterSpacing = 0.1.em,
                lineHeight = 50.sp
            )

            LazyColumn {
                items(products) { product ->
                    ProductItem(
                        product = product,
                        controller = controller,
                        productRepository = productRepository
                    )
                }
            }
        }
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

@SuppressLint("SimpleDateFormat")
@Composable
fun ProductItem(
    product: Product,
    controller: NavHostController,
    productRepository: ProductViewModel
) {
    var isDetailsVisible by remember { mutableStateOf(false) }

    // Calculate total price based on product details
    val totalPrice = when (product.selectedBiketype) {
        "Mountain Bike" -> 300 * product.quantity.toInt()
        "City Bike" -> 200 * product.quantity.toInt()
        "Kid Bike" -> 150 * product.quantity.toInt()
        else -> 0 // Handle default case
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White)
                .clickable { isDetailsVisible = !isDetailsVisible }
        ) {
            Text(
                text = product.name,
                modifier = Modifier.padding(8.dp),
                color = Color(0xFFFFFFFF),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            if (isDetailsVisible) {
                Text(text = "ID: ${product.idNumber}", modifier = Modifier.padding(8.dp))
                Text(text = "Type: ${product.selectedBiketype}", modifier = Modifier.padding(8.dp))
                Text(text = "Quantity: ${product.quantity}", modifier = Modifier.padding(8.dp))
                Text(text = "Total Price: $totalPrice", modifier = Modifier.padding(8.dp))
                Text(text = "Date: ${product.date}", modifier = Modifier.padding(8.dp))

            }
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(rememberNavController())
}
