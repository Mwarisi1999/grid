package com.example.mysaff

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class Urbanfoodmain : AppCompatActivity() {

        var adapter : UrbanAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_urbanfoodmain)

        val f = ArrayList<Urbanfood>()
        f.add(Urbanfood("Matooke & Chicken","20,000Shs",R.drawable.urban))
        f.add(Urbanfood("Matooke & Meat","18,000Shs",R.drawable.urban))
        f.add(Urbanfood("Matooke & Fish","20,000Shs",R.drawable.urban))
        f.add(Urbanfood("Matooke & Cowpeas","12,000Shs",R.drawable.urban))
        f.add(Urbanfood("Matooke & Beans","11,000Shs",R.drawable.urban))

        f.add(Urbanfood("Rice & Chicken","22,000Shs",R.drawable.urban))
        f.add(Urbanfood("Rice & Meat","20,000Shs",R.drawable.urban))
        f.add(Urbanfood("Rice & Fish","20,000Shs",R.drawable.urban))
        f.add(Urbanfood("Rice & Peas","15,000Shs",R.drawable.urban))
        f.add(Urbanfood("Rice & Beans","10,000Shs",R.drawable.urban))

        f.add(Urbanfood("Macrons & Chicken","15,000Shs",R.drawable.urban))
        f.add(Urbanfood("Macrons & Meat","15,000Shs",R.drawable.urban))
        f.add(Urbanfood("Macrons & Fish","15,000Shs",R.drawable.urban))

        f.add(Urbanfood("Posho & Chicken","15,000Shs",R.drawable.urban))
        f.add(Urbanfood("Posho & Fish","15,000Shs",R.drawable.urban))
        f.add(Urbanfood("Posho & Meat","12,000Shs",R.drawable.urban))
        f.add(Urbanfood("Posho & Peas","10,000Shs",R.drawable.urban))
        f.add(Urbanfood("Posho & Beans","10,000Shs",R.drawable.urban))

        val c = UrbanAdapter(this,f)
        val h = findViewById<ListView>(R.id.urbanfoodlistview)
        h.adapter = c
    }



        class UrbanAdapter : BaseAdapter {
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