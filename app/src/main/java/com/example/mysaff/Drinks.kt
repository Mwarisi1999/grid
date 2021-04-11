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

class Drinks : AppCompatActivity() {
    var adapter : DrinkAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drinks)
        val f = ArrayList<mydrinks>()
        f.add(mydrinks("Soda 500ml","1,500Shs",R.drawable.drink))
        f.add(mydrinks("Soda 1litre","2,500Shs",R.drawable.drink))
        f.add(mydrinks("Soda 2litres","5,000Shs",R.drawable.drink))
        f.add(mydrinks("Rwenzori small","1,500Shs",R.drawable.drink))
        f.add(mydrinks("Rwenzori Big","2,500Shs",R.drawable.drink))
        f.add(mydrinks("BlueWave Big","2,000Shs",R.drawable.drink))
        f.add(mydrinks("BlueWave small","1000Shs",R.drawable.drink))
        f.add(mydrinks("Kashera","2,000Shs",R.drawable.drink))
        f.add(mydrinks("Passion Juice","2,500Shs",R.drawable.drink))
        f.add(mydrinks("Mango Juice","2,000Shs",R.drawable.drink))
        f.add(mydrinks("Orange Juice","2,000Shs",R.drawable.drink))
        f.add(mydrinks("Lemon Juice","2,700Shs",R.drawable.drink))
        f.add(mydrinks("Sting","4,000Shs",R.drawable.drink))
        f.add(mydrinks("Rockboom","5,000Shs",R.drawable.drink))
        f.add(mydrinks("Minute Maid small","4,000Shs",R.drawable.drink))
        f.add(mydrinks("Minute Maid Big","7,000Shs",R.drawable.drink))
        f.add(mydrinks("Milk","4,000Shs",R.drawable.drink))
        f.add(mydrinks("Coffee","4,000Shs",R.drawable.drink))


        val c = DrinkAdapter(this, f)
        val m = findViewById<ListView>(R.id.drinkslistview)
        m.adapter = c

    }

    class DrinkAdapter : BaseAdapter{
        var x: Context? = null
        var y = ArrayList<mydrinks>()

        constructor(a: Context, b: ArrayList<mydrinks>) : super() {
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