package com.example.plantsapp

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

class Plant {

     constructor(){



     }

     constructor(n : String,u: String ,d: String){
         this.name = n
         this.url = u
         this.desc = d


     }



     var name : String = ""
     var url: String = ""
     var desc: String = ""


//    val intent  = Intent(this,PlantList2::class.java)
//    startActivity(intent)

 }