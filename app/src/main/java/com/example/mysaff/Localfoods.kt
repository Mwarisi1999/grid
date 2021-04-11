package com.example.mysaff

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class Localfoods : AppCompatActivity() {
  var adapter : LocalAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localfoods)
        val f = ArrayList<Urbanfood>()

        f.add(Urbanfood("Matooke & Pasted Chicken","27,000Shs",R.drawable.local))
        f.add(Urbanfood("Matooke & Pasted Meat","25,000Shs",R.drawable.local))
        f.add(Urbanfood("Matooke & Pasted Fish","25,000Shs",R.drawable.local))
        f.add(Urbanfood("Matooke & Pasted Malewa","25,000Shs",R.drawable.local))
        f.add(Urbanfood("Matooke & Gnuts","20,000Shs",R.drawable.local))
        f.add(Urbanfood("Matooke & Pasted Greens","20,000Shs",R.drawable.local))
        f.add(Urbanfood("Matooke & Pasted beans","20,000Shs",R.drawable.local))

        f.add(Urbanfood("Rice & Pasted Chicken","27,000Shs",R.drawable.local))
        f.add(Urbanfood("Rice & Pasted Meat","25,000Shs",R.drawable.local))
        f.add(Urbanfood("Rice & Pasted fish","27,000Shs",R.drawable.local))
        f.add(Urbanfood("Rice & Gnuts","23,000Shs",R.drawable.local))
        f.add(Urbanfood("Rice & Pasted Chicken","27,000Shs",R.drawable.local))
        f.add(Urbanfood("Rice & Pasted beans","20,000Shs",R.drawable.local))
        f.add(Urbanfood("Rice & Pasted Greens","15,000Shs",R.drawable.local))

        f.add(Urbanfood("Posho & Pasted Chicken","24,000Shs",R.drawable.local))
        f.add(Urbanfood("Posho & Pasted Meat","20,000Shs",R.drawable.local))
        f.add(Urbanfood("Posho & Pasted Fish","24,000Shs",R.drawable.local))
        f.add(Urbanfood("Posho & Pasted Beans","13,000Shs",R.drawable.local))
        f.add(Urbanfood("Posho & Greens","10,000Shs",R.drawable.local))

        f.add(Urbanfood("Kaalo & Pasted Chicken","27,000Shs",R.drawable.local))
        f.add(Urbanfood("Kaalo & Pasted Meat","25,000Shs",R.drawable.local))
        f.add(Urbanfood("Kaalo & Pasted Fish","25,000Shs",R.drawable.local))
        f.add(Urbanfood("Kaalo & Pasted Malewa","25,000Shs",R.drawable.local))
        f.add(Urbanfood("Kaalo & Gnuts","20,000Shs",R.drawable.local))
        f.add(Urbanfood("Kaalo & Pasted Greens","20,000Shs",R.drawable.local))
        f.add(Urbanfood("Kaalo & Pasted beans","20,000Shs",R.drawable.local))



        val c = LocalAdapter(this,f)
        val m = findViewById<ListView>(R.id.localfoodlistview)
        m.adapter = c
    }



    class LocalAdapter : BaseAdapter {
        var x: Context? = null
        var y = ArrayList<Urbanfood>()

        constructor(a: Context, b: ArrayList<Urbanfood>) : super() {
            this.x = a
            this.y = b
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val pan = x!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val p = pan.inflate(R.layout.myurbanlayout, null)

            val photo = p.findViewById<ImageView>(R.id.imageView3)
            val text1 = p.findViewById<TextView>(R.id.textView5)
            val text2 = p.findViewById<TextView>(R.id.textView6)

            text1.text = y[position].nameurban
            text2.text = y[position].price
            photo.setImageResource(y[position].imageurban!!)
            return p
        }

        override fun getItem(position: Int): Any {
            return y[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return y.size
        }

    }
}