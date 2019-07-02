package com.example.plantsapp1

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_plant_list.*


public class PlantList : AppCompatActivity() {

    private val TAGO = "PlantList"

    //vars
    public val mNames = ArrayList<String>()
    public val mImageUrls = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_list)

        initImageBitmaps()

    }


    private fun initImageBitmaps() {
        Log.d(TAGO, "initImageBitmaps: preparing bitmaps.")


        mImageUrls.add("https://bestplants.com/wp-content/uploads/aloe-vera-1200-630-FB-08312018-min.jpg")
        mNames.add("Devil's Ivy")



        mImageUrls.add("https://cdn1.medicalnewstoday.com/content/images/articles/318/318591/aloe-vera-plants.jpg")
        mNames.add("Aloe Vera")

        mImageUrls.add("https://cdn1.medicalnewstoday.com/content/images/articles/318/318591/aloe-vera-plants.jpg")
        mNames.add("Arecca Palms")

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Starr_080117-1577_Ocimum_tenuiflorum.jpg/450px-Starr_080117-1577_Ocimum_tenuiflorum.jpg")
        mNames.add("Indian Basil")

        mImageUrls.add("https://4.imimg.com/data4/DB/YB/MY-13145983/dracaena-fragrans-plant-250x250.jpg")
        mNames.add("Dracaena")

        mImageUrls.add("https://images-na.ssl-images-amazon.com/images/I/41OWo7%2BKu3L._SY355_.jpg")
        mNames.add("Snake Plant")

        mImageUrls.add("https://i.etsystatic.com/10818091/r/il/45e7d5/866329830/il_794xN.866329830_bxm8.jpg")
        mNames.add("Weeping fig")


        mImageUrls.add("http://www.daun.com.my/wp-content/uploads/2016/07/Spider-Plant-big-e1495886818464-600x450.jpg")
        mNames.add("Spider plant")


        initRecyclerView()

    }

    private fun initRecyclerView() {


        val recycler = recycler_view
        val adapter = RecyclerViewAdapter(  mNames, mImageUrls,  this.applicationContext)
        recycler.adapter = adapter;
        recycler.setLayoutManager(LinearLayoutManager(this))
    }


}
