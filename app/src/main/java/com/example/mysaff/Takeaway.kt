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

class Takeaway : AppCompatActivity() {

    var adapter : TakeawayAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_takeaway)
        val f = ArrayList<Take>()
        f.add(Take("Chips and Chicken","20,000Shs",R.drawable.takeaway))
        f.add(Take("Chips and Meat","15,000Shs",R.drawable.takeaway))
        f.add(Take("Chips Only","5,000Shs",R.drawable.takeaway))
        f.add(Take("Rice and Chicken","20,000Shs",R.drawable.takeaway))
        f.add(Take("Rice and Meat","15,000Shs",R.drawable.takeaway))
        f.add(Take("Chicken","15,000Shs",R.drawable.takeaway))
        f.add(Take("Meat","10,000Shs",R.drawable.takeaway))
        f.add(Take("Beans","7,000Shs",R.drawable.takeaway))
        f.add(Take("Peas","8,000Shs",R.drawable.takeaway))


        val c = TakeawayAdapter(this, f)
        val m = findViewById<ListView>(R.id.takeawaylistview)
        m.adapter = c


    }
class TakeawayAdapter: BaseAdapter{
    var x: Context? = null
    var y = ArrayList<Take>()

    constructor(a: Context, b: ArrayList<Take>) : super() {
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