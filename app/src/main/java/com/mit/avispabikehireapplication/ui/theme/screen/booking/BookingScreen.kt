@file:OptIn(ExperimentalMaterial3Api::class)

package com.mit.avispabikehireapplication.ui.theme.screen.booking

import android.app.DatePickerDialog
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mit.avispabikehireapplication.data.ProductViewModel
import com.mit.avispabikehireapplication.navigation.ROUTE_DETAILS
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


//@RequiresApi(Build.VERSION_CODES.N)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(
    selectedDate: Date?,
    onDateSelected: (Date) -> Unit
) {
    val calendar = Calendar.getInstance()
    val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        onDateSelected(calendar.time)
    }
    val context = LocalContext.current

    OutlinedButton(
        onClick = {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(context, dateSetListener, year, month, dayOfMonth)
            datePickerDialog.show()
        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Color.Transparent),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color(0xFFFF9800),
        ),
        border = BorderStroke(0.5.dp, Color.Black),
        contentPadding = PaddingValues(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                tint = MaterialTheme.colorScheme.background,
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = selectedDate?.formatToDisplayDate() ?: "Select Date",
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                color = Color(0xFF000000),
            )
        }
    }
}

fun Date.formatToDisplayDate(): String {
    val sdf = SimpleDateFormat("dd/MMMM/yyyy", Locale.getDefault())
    return sdf.format(this)
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(controller: NavHostController) {


    val context= LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    val bikeTypes = listOf("Mountain Bike", "City Bikes", "Kid Bikes") // Add your specific options here
    //var selectedBikeType by remember { mutableStateOf(bikeTypes[0]) }
    val options by remember { mutableStateOf(bikeTypes) }
    var selectedOption by remember { mutableStateOf(options[0]) }

    var selectedTypeIndex by remember { mutableIntStateOf(0) }
//    var selectedType by remember { mutableStateOf(typeOptions[0]) }
    var selectedDate by remember { mutableStateOf<Date?>(null) }
//    var pickedDate by remember { mutableStateOf(LocalDate.now())    }
//    val formattedDate by remember { derivedStateOf { DateTimeFormatter.ofPattern("MM dd yyyy").format(pickedDate)}    }
    val dateDialogState = rememberMaterialDialogState()






    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier= Modifier.background(Color.White),)
    {
        Text(
            text = "BOOKING",
            color = Color(0xFFFF9800),
            modifier = Modifier.padding(16.dp),
            fontFamily = FontFamily.Serif,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(30.dp))

        // Form
        var name by remember { mutableStateOf("") }
        var idNumber by remember { mutableStateOf("") }
        var selectedBikeType by remember { mutableStateOf("") }
        var quantity by remember { mutableStateOf("") }
        //var selectedDate by remember { mutableStateOf<Date?>(null) }
        var date by remember { mutableStateOf("") }

        // prices
        // Define the prices for each bike type
        val mountainBikePrice = 300
        val cityBikePrice = 200
        val kidBikePrice = 150

        // Calculate the total price based on the selected bike type and quantity
        val totalPrice = when (selectedBikeType) {
            "City Bike" -> cityBikePrice * quantity.toInt()
            "Mountain Bike" -> mountainBikePrice * quantity.toInt()
            "Kid Bike" -> kidBikePrice * quantity.toInt()
            else -> 0 // Handle default case
        }


        OutlinedTextField(
            value = name,
            label = { Text(text = "Name", color = Color(0xFFFF9800)) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onValueChange = {
                name = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black, // Set text color to black
                focusedBorderColor = Color.Black, // Change border color when focused
                unfocusedBorderColor = Color.Gray, // Change border color when not focused
                cursorColor = Color(0xFFFF9800) // Set cursor color to black
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.background
                )
            }
        )



        OutlinedTextField(
            value = idNumber,
            label = { Text(text = "Id Number", color = Color(0xFFFF9800)) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onValueChange = {
                idNumber = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black, // Set text color to black
                focusedBorderColor = Color.Black, // Change border color when focused
                unfocusedBorderColor = Color.Gray, // Change border color when not focused
                cursorColor = Color(0xFFFF9800) // Set cursor color to black
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.background
                )
            }
        )

        OutlinedTextField(
            value = quantity,
            label = { Text(text = "Quantity", color = Color(0xFFFF9800)) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onValueChange = {
                quantity = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black, // Set text color to black
                focusedBorderColor = Color.Black, // Change border color when focused
                unfocusedBorderColor = Color.Gray, // Change border color when not focused
                cursorColor = Color(0xFFFF9800) // Set cursor color to black
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.background
                )
            }
        )


        OutlinedDropdown(
            value = selectedBikeType,
            onValueChange = { selectedBikeType = it },
            options = bikeTypes,
            label = { Text("Bike Type",color = Color(0xFF000000)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )

        Text("Total Price: $totalPrice", modifier = Modifier.padding(8.dp),color= Color.Black)

        CustomDatePicker(
            selectedDate = selectedDate,
            onDateSelected = { date -> selectedDate = date
                // Call checkAvailability function here
                val productViewModel = ProductViewModel(controller, context)
                productViewModel.checkAvailability(selectedBikeType, date) { isAvailable ->
                    if (isAvailable) {
                        // Bike is available for selected date
                        Toast.makeText(context, "Bike is available for selected date", Toast.LENGTH_SHORT).show()
                    } else {
                        // Bike is not available for selected date
                        Toast.makeText(context, "Bike is not available for selected date", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )



        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                // Create an instance of ProductViewModel
                val productViewModel = ProductViewModel(controller, context)

                // Call checkAvailability function on the instance
                selectedDate?.let {
                    productViewModel.checkAvailability(selectedBikeType, it) { isAvailable ->
                        if (isAvailable) {
                            // Bike is available for selected date
                            // Proceed with saving the product using the same instance of ProductViewModel
                            productViewModel.saveProduct(
                                name.trim(),
                                idNumber.trim(),
                                selectedBikeType.trim(),
                                quantity.trim(),
                                selectedDate?.formatToDisplayDate() ?: ""
                            )
                            controller.navigate(ROUTE_DETAILS)
                        } else {
                            // Bike is not available for selected date
                            // Display a message or UI indication that bikes are not available
                            Toast.makeText(context, "Bikes are not available for the selected date and type", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
//
//                // Create an instance of ProductViewModel
//                val productViewModel = ProductViewModel(controller, context)
//
//                // Call checkAvailability function on the instance
//                selectedDate?.let {
//                    productViewModel.checkAvailability(selectedBikeType, it) { isAvailable ->
//                        if (isAvailable) {
//                            // Bike is available for selected date
//                            // Proceed with saving the product
//                            val productRepository = ProductViewModel(controller, context)
//                            productRepository.saveProduct(
//                                name.trim(),
//                                idNumber.trim(),
//                                selectedBikeType.trim(),
//                                quantity.trim(),
//                                selectedDate?.formatToDisplayDate() ?: ""
//                            )
//                            controller.navigate(ROUTE_DETAILS)
//                        } else {
//                            // Bike is not available for selected date
//                            // Display a message or UI indication that bikes are not available
//                            Toast.makeText(context, "Bikes are not available for the selected date and type", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
            },
            modifier = Modifier
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFF9800)),
        )
        {
            Text(
                text = " DONE",
                color = Color.White
            )


        }
    }

}

@Composable
fun OutlinedDropdown(
    value: String,
    onValueChange: (String) -> Unit,
    options: List<String>,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    var hasSelection by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        BasicTextField(
            value = if (hasSelection) options[selectedIndex] else "Type of Bike",
            onValueChange = {},
            textStyle = TextStyle(color = Color(0xFFFF9800)),
            readOnly = true,
            decorationBox = { innerTextField ->
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .border(1.dp, Color.Gray)
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable { expanded = !expanded },
                ) {
//                    Icon(
//                        imageVector = Icons.Default.DateRange,
//                        contentDescription = null,
//                        tint = MaterialTheme.colorScheme.surfaceTint
//
//                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    innerTextField()
                }
            },

        )

        if (expanded) {
            options.forEachIndexed { index, option ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedIndex = index
                            onValueChange(option)
                            expanded = false
                            hasSelection = true
                        }
                        .padding(8.dp)
                ) {
                    Text(text = option,color= Color(0xFFFF9800))
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun BookingScreenPreview() {
    BookingScreen(rememberNavController())

}

