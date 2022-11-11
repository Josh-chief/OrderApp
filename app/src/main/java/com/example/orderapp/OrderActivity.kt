package com.example.orderapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText


class OrderActivity : AppCompatActivity() {
    var price  = "" //declare a global message variable
    private var amt:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        //initializing object reference for XML element
        var orderTextView: TextView = findViewById(R.id.order_textview)
        var fullName : TextInputEditText = findViewById(R.id.full_name)
        var address: TextInputEditText = findViewById(R.id.address)
        var phoneNumber : TextInputEditText = findViewById(R.id.phone_number)
        var orderDetails:TextInputEditText = findViewById(R.id.order_description)

        //the order button
        var sameDayChecked : RadioButton = findViewById(R.id.sameday)
        var nextDayChecked : RadioButton = findViewById(R.id.nextday)
        var selfPickChecked : RadioButton = findViewById(R.id.pickup)

        //the order button
        var orderButton : Button = findViewById(R.id.submitOrder)

        //retrieve the order given from the previous activity
        var orderedItem = intent.getStringExtra("ORDER")
        orderTextView.text = orderedItem //show the ordered item from the order activity
        var Total = intent.getStringExtra("PRICE")
        if (Total != null){
            amt += Total.toInt() //convert string amt to int

        }
        //send order details to a ReceiptActivity and display the details of the order
        //from the main and OrderActivity

        orderButton.setOnClickListener {
            //check which radio button has been selected
            if(sameDayChecked.isChecked){
                amt += 300
                //add delivery fee
            } else if(nextDayChecked.isChecked){
                amt += 100
                //add delivery fee
            }else if(selfPickChecked.isChecked){
                amt += 0
                //maintain same delivery fee
            }
            price = amt.toString()//convert amount to string to ensure intent transfer

            var intentReceiptActivity = Intent(this, ReceiptActivity::class.java)

            intentReceiptActivity.putExtra("TOTAL", price )//intent transfer

            startActivity(intentReceiptActivity)
        }

    }
}