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

class RoastedFoods : AppCompatActivity() {

    var adapter : RoastedAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roasted_foods)
        val f = ArrayList<Roasts>()

        f.add(Roasts("Roasted Chicken","15,000Shs",R.drawable.roasted))
        f.add(Roasts("Roasted Meat","10,000Shs",R.drawable.roasted))
        f.add(Roasts("Roasted Pork","10,000Shs",R.drawable.roasted))
        f.add(Roasts("Roasted Matooke","4,000Shs",R.drawable.roasted))
        f.add(Roasts("Roasted Matooke and Chicken","20,000Shs",R.drawable.roasted))
        f.add(Roasts("Roasted Matooke and Meat","15,000Shs",R.drawable.roasted))
        f.add(Roasts("Roasted Matooke and Pork","12,000Shs",R.drawable.roasted))
        f.add(Roasts("Roasted Matooke and fish","20,000Shs",R.drawable.roasted))
        f.add(Roasts("Roasted Cassava","3,000Shs",R.drawable.roasted))




        val c =RoastedAdapter(this, f)
        val m = findViewById<ListView>(R.id.roastedlistview)
        m.adapter = c

    }

    class RoastedAdapter : BaseAdapter{
        var x: Context? = null
        var y = ArrayList<Roasts>()

        constructor(a: Context, b: ArrayList<Roasts>) : super() {
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