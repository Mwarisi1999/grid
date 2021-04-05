package com.example.mysaff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FoodDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)


        var b = findViewById<Button>(R.id.button)
        b.setOnClickListener {
            startActivity(Intent(this, Urbanfoodmain::class.java))
        }


        var bundle =  intent.extras
        var x = findViewById<ImageView>(R.id.imageView)
        x.setImageResource(bundle!!.getInt("image"))

        var y = findViewById<TextView>(R.id.textView2)
        y.text = bundle.getString("name")
        var z = findViewById<TextView>(R.id.textView3)
        z.text = bundle.getString("des")

        var m = findViewById<TextView>(R.id.textView4)
        m.setOnClickListener {
            startActivity(Intent(this, Localfoods::class.java))
        }
    }
}