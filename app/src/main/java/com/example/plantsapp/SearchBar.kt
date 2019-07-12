package com.example.plantsapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_plant_list.*
import kotlinx.android.synthetic.main.activity_search_bar.*
import kotlinx.android.synthetic.main.activity_plant_list.recycler_view as recycler_view1

class SearchBar : AppCompatActivity() {

    private val TAGO = "PlantList"

    val plantList = DbStore.getPlantdata()
    var filteredList = ArrayList<Plant>()
    var adapter: RecyclerViewAdapter? = null


    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant_list)
        initImageBitmaps()
        handleIntent(intent)

    }
    
    //search_bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

    override fun onNewIntent(intent: Intent) {
        if (intent != null) {
            handleIntent(intent)
        }
    }

    private fun handleIntent(intent: Intent){
        if (Intent.ACTION_SEARCH == intent.action){
            val query = intent.getStringExtra(SearchManager.QUERY)
            val names = this.plantList.filter { n -> n.name.contains(query,true) }

            filteredList.clear()
            names.forEach { n -> filteredList.add(n) }
            adapter?.notifyDataSetChanged()
            /*
            val recycler = recycler_view
            val adapter = RecyclerViewAdapter(  filteredList,  this.applicationContext)
            recycler.adapter = adapter;
            recycler.setLayoutManager(LinearLayoutManager(this))
            */

//            val names = this.mNames.filter { n -> n.contains(query,true) }

         //   val urls = this.mNames.filter { n -> n.contains(query,true) }
        }
    }

    private fun initImageBitmaps() {
        Log.d(TAGO, "initImageBitmaps: preparing bitmaps.")


        initRecyclerView()

    }

    private fun initRecyclerView() {
        val recycler = recycler_view
        this.filteredList = plantList;
         adapter = RecyclerViewAdapter(  filteredList,  this.applicationContext)
        recycler.adapter = adapter;
        recycler.setLayoutManager(LinearLayoutManager(this))
    }
}
