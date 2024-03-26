package com.mit.avispabikehireapplication.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mit.avispabikehireapplication.model.Product
import com.mit.avispabikehireapplication.navigation.ROUTE_LOGIN
import java.util.Date

class ProductViewModel(var controller: NavHostController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(controller, context)
        if (!authRepository.loggedin()) {
            controller.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveProduct(
        name: String,
        idNumber: String,
        selectedBiketype: String,
        quantity: String,
        date: String,

        //text: Any?
    ) {
        var id = System.currentTimeMillis().toString()

        var productData = Product(name, idNumber, selectedBiketype, quantity,date,id)
        var productRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        productRef.setValue(productData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewProducts(
        product: MutableState<Product>,
        products: SnapshotStateList<Product>
    ): SnapshotStateList<Product> {
        var ref = FirebaseDatabase.getInstance().getReference().child("Products")

//        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                progress.dismiss()
                products.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Product::class.java)
                    product.value = value!!
                    products.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return products
    }

//    fun checkAvailability(selectedBikeType: String, selectedDate: Date, callback: (Boolean) -> Unit) {
//        val ref = FirebaseDatabase.getInstance().getReference().child("Products")
//        ref.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                var isAvailable = true
//                for (snap in snapshot.children) {
//                    val product = snap.getValue(Product::class.java)
//                    if (product != null && product.selectedBiketype == selectedBikeType && product.date == selectedDate.toString()) {
//                        isAvailable = false
//                        break
//                    }
//                }
//                callback(isAvailable)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                callback(false)
//                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//    }


//    fun checkAvailability(selectedBikeType: String, selectedDate: Date, callback: (Boolean) -> Unit) {
//        val ref = FirebaseDatabase.getInstance().getReference().child("Products")
//        ref.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                var isAvailable = true
//                val bikeLimits = mapOf(
//                    "Mountain Bike" to 50, // Specify the limit for each bike type
//                    "City Bike" to 30,
//                    "Kid Bike" to 20
//                )
//
//                var count = 0
//                val limit = bikeLimits[selectedBikeType] ?: 0 // Get the limit for the selected bike type
//                for (snap in snapshot.children) {
//                    val product = snap.getValue(Product::class.java)
//                    if (product != null && product.selectedBiketype == selectedBikeType && product.date == selectedDate.toString()) {
//                        count++
//                        if (count >= limit) {
//                            isAvailable = false // Exceeds the bike limit
//                            break
//                        }
//                    }
//                }
//                callback(isAvailable)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                callback(false)
//                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//    }

    fun checkAvailability(selectedBikeType: String, selectedDate: Date, callback: (Boolean) -> Unit) {
        val ref = FirebaseDatabase.getInstance().getReference().child("Products")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var isAvailable = true
                val bikeLimits = mapOf(
                    "Mountain Bike" to 10, // Specify the limit for each bike type
                    "City Bike" to 15,
                    "Kid Bike" to 20
                )

                var count = 0
                val limit = bikeLimits[selectedBikeType] ?: 0 // Get the limit for the selected bike type
                for (snap in snapshot.children) {
                    val product = snap.getValue(Product::class.java)
                    if (product != null && product.selectedBiketype == selectedBikeType && product.date == selectedDate.toString()) {
                        count++
                    }
                }
                if (count >= limit) {
                    isAvailable = false // Exceeds the bike limit
                }
                callback(isAvailable)
            }

            override fun onCancelled(error: DatabaseError) {
                callback(false)
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }




}