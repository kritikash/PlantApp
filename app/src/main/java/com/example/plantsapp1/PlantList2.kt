package com.example.plantsapp1

import android.content.Context
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.BitmapFactory
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_plant_list2.*
import org.w3c.dom.Text
import java.util.ArrayList


class PlantList2 : AppCompatActivity() {

    var url = ""
    var txt = ""
    var pos = 0
    public val mText = ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_list2)
        loadDescList()
        this.title = intent.extras["PLANT_NAME"].toString()
        this.url = intent.extras["URL"].toString()
//        this.txt = intent.extras["Text"].toString()

        this.pos = intent.extras["POS"] as Int



        val text = mText.get(pos) //getIntent().getExtras().getString("Text")
        val textView = findViewById<TextView>(R.id.description)
        textView.setText(text)










        Glide.with(this)
                .load(this.url)
                .into(img)

    }


    fun loadDescList(){
        mText.add("It is almost impossible to kill and it stays green even when kept in the dark." +
                " It is sometimes mistakenly labeled as a Philodendron in plant stores." +
                " It is commonly known as money plant in many parts of the Indian subcontinent.")

        mText.add("Aloe vera is a stemless or very short-stemmed plant growing to 60–100 cm (24–39 in) tall, spreading by offsets. The leaves are thick and fleshy, green to grey-green, with some varieties showing white flecks on their upper and lower stem surface.")

        mText.add("Dypsis lutescens, also known as golden cane palm, areca palm, yellow palm, or butterfly palm, is a species of flowering plant in the Arecaceae family, native to Madagascar and South India and naturalized in the Andaman Islands")
        mText.add("Ocimum tenuiflorum (synonym Ocimum sanctum), commonly known as holy basil, tulasi (sometimes spelled thulasi) or tulsi, is an aromatic perennial plant in the family Lamiaceae. It is native to the Indian subcontinent and widespread as a cultivated plant throughout the Southeast Asian tropics.")
        mText.add("Dracaena reflexa is a popular houseplant with origins in Madagascar and other Indian ocean islands. The origin of the plant name comes from the ancient Greek word drakaina or “female dragon,” due to a red gum-like resin in the stems of dracaena that was likened to dragon blood. Centuries ago, this resin was used for toothpaste, dyes, and medicines. Today, it is still used for varnish and photoengraving. The dracaena plant is also known as the Song of India and Pleomele.")
        mText.add(" An easy-care houseplant, you can't do much better than snake plant. This hardy indoor is still popular today -- generations of gardeners have called it a favorite -- because of how adaptable it is to a wide range of growing conditions. Most snake plant varieties have stiff, upright, sword-like leaves that may be banded or edged in gray, silver, or gold. Snake plant's architectural nature makes it a natural choice for modern and contemporary interior designs. It's one of the best houseplants around! ")
        mText.add("The weeping fig is part of the Ficus plant genus (scientific name: F. benjamina) and tree like, in looks. With large arching branches and long pointed leaves, it looks attractive indoors (apart from leaves dropping).")
        mText.add("Spider plants produce a rosette of long, thin, arched foliage that is solid green or variegated with white. These easy-to-grow houseplants look especially nice in a hanging basket and were a favorite in Victorian-era households. Here’s how to grow spider plants in your home!")

    }
}

