package com.example.plantsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_plant_list2.*
import java.util.ArrayList


class PlantList2 : AppCompatActivity() {

    var url = ""
    var pos = 0
    public val mText = ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_list2)

        this.title = intent.extras["PLANT_NAME"].toString()
        this.url = intent.extras["URL"].toString()
        val text =  intent.extras["Text"].toString()

        val textView = findViewById<TextView>(R.id.description)
        textView.setText(text)
        textView.movementMethod = ScrollingMovementMethod()
















        Glide.with(this)
                .load(this.url)
                .into(img)
    }
}

