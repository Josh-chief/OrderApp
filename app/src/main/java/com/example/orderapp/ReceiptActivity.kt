package com.example.orderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ReceiptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        var showReceipt : TextView = findViewById(R.id.showReceipt)
        var payBtn : FloatingActionButton = findViewById(R.id.btnPayment)

        //receive any data you passed from the second activity and use it her
        var orderedItem = intent.getStringExtra("TOTAL")

        showReceipt.text = orderedItem.toString()//convert intent total to string

        //display the data receive into the showReceipt textview for the user to see

        //LOGIC to pay
        payBtn.setOnClickListener{
            //launch your phone's simToolkit (STK'S )through ana explicit intent
            //research on the way to fetch the specific STK'S package name
        }
    }
}