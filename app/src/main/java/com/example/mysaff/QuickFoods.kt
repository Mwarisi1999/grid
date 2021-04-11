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

class QuickFoods : AppCompatActivity() {

    var adapter : QuickAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_foods)
        val f = ArrayList<Quick>()
        f.add(Quick("Chapatti and Beans","2,000Shs",R.drawable.logo))
        f.add(Quick("Chapatti and Meat","2,500Shs",R.drawable.logo))
        f.add(Quick("Chapatti and Peas","2,000Shs",R.drawable.logo))
        f.add(Quick("Deep Fried Chicken","5,000Shs",R.drawable.logo))
        f.add(Quick("Deep Fried Pork","5,000Shs",R.drawable.logo))
        f.add(Quick("Deep Fried Fish","6,000Shs",R.drawable.logo))
        f.add(Quick("Snacks","4,000Shs",R.drawable.logo))
        f.add(Quick("Superghetti","3,000Shs",R.drawable.logo))
        f.add(Quick("Noodles","2,000Shs",R.drawable.logo))



        val c = QuickAdapter(this, f)
        val m = findViewById<ListView>(R.id.quicklistview)
        m.adapter = c
    }

    class QuickAdapter : BaseAdapter{
        var x: Context? = null
        var y = ArrayList<Quick>()

        constructor(a: Context, b: ArrayList<Quick>) : super() {
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