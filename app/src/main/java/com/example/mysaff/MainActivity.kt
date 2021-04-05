package com.example.mysaff

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var adapter : FoodAdapter ?= null
    var foodlist = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        foodlist.add(Food("Urban Foods","These include modern, current foods prepared in a modern/western format",R.drawable.urban))
        foodlist.add(Food("Local Foods","These include local or normal foods prepared in an ancient format",R.drawable.local))
        foodlist.add(Food("Roasted Foods","These include all sort of foods prepared in a roasted format",R.drawable.roasted))
        foodlist.add(Food("Take-aways","These include all sort of foods prepared in a modern/western format but packed and sealed",R.drawable.takeaway))
        foodlist.add(Food("Drinks","These include all sorts of drinks",R.drawable.drink))
        foodlist.add(Food("Quick Foods","These include all sorts of emergency foods",R.drawable.logo))

        adapter = FoodAdapter(this,foodlist)
        val grid = findViewById<GridView>(R.id.gridview)
        grid.adapter = adapter

    }

    class FoodAdapter: BaseAdapter{
        var foodlist = ArrayList<Food>()
        var context: Context?= null

        constructor(context: Context?, foodlist: ArrayList<Food>): super() {
            this.foodlist = foodlist
            this.context = context
        }


        override fun getView(index: Int, convertView: View?, parent: ViewGroup?): View {
            var food = this.foodlist[index]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview = inflater.inflate(R.layout.mylayout, null)

            val photo = foodview.findViewById<ImageView>(R.id.imageView2)
            val text1 = foodview.findViewById<TextView>(R.id.textView)

            photo.setImageResource(food.image!!)
            text1.text = food.name

            photo.setOnClickListener{
                var intent = Intent(context, FoodDetailsActivity::class.java)
                intent.putExtra("name",food.name)
                intent.putExtra("des",food.des)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            return foodview

        }

        override fun getItem(position: Int): Any {
            return position
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return foodlist.size
        }

    }
}