package com.example.orderapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast

import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var orderMessage = "" //declare a global message variable


    var orderPrice  = "" //declare a global message variable
    private var amt:Int=0 //declare a global message variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)

        //Reference the XML imager view objects from your activity class file
        var donut: ImageView = findViewById(R.id.donut)
        var iceCream: ImageView = findViewById(R.id.ice_cream)
        var froyo: ImageView = findViewById(R.id.froyo)
        var orderButton: FloatingActionButton = findViewById(R.id.btnOrder)

        //The check boxes
        var sprinkleCheck : CheckBox = findViewById(R.id.sprinkles)
        var oreoCheck : CheckBox = findViewById(R.id.oreos)
        var fruitCheck : CheckBox = findViewById(R.id.fruit)

        //When the donut image is clicked
        donut.setOnClickListener{
            //fetch message from string.xml using getString() method
            orderMessage = getString(R.string.donut_order_message)
            displayToast(orderMessage)
            amt += 50
        }

        //When the icecream image is clicked
        iceCream.setOnClickListener{
            //fetch message from string.xml using getString() method
            orderMessage = getString(R.string.ice_cream_order_message)
            displayToast(orderMessage)
            amt += 150
        }

        //when the froyo image is clicked
        froyo.setOnClickListener{
            //fetch message from string.xml using getString() method
            orderMessage = getString(R.string.froyo_order_message)
            displayToast(orderMessage)
            amt += 200
        }
        //logic for the floating action button
        orderButton.setOnClickListener{
            //checking whether the checkboxes have been selected

            if (sprinkleCheck.isChecked){
                amt += 20
                //do sth
            }
            if (oreoCheck.isChecked){
                amt += 30
                //do sth
            }
            if (fruitCheck.isChecked){
                amt =+ 50
                //do sth
            }
            orderPrice= amt.toString()//convert total to string

            var intentOrder = Intent(this, OrderActivity::class.java)

            intentOrder.putExtra("ORDER", orderMessage )
            intentOrder.putExtra("PRICE", orderPrice )
            startActivity(intentOrder)
        }
    }
    //Instead of having many Toast message declarations
    private fun displayToast(message: String){
        Toast.makeText(applicationContext, message,Toast.LENGTH_SHORT).show()
    }
}