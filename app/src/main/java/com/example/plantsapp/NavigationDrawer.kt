package com.example.plantsapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.media.session.MediaButtonReceiver.handleIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_navigation_drawer.view.*
import kotlinx.android.synthetic.main.activity_search_bar.*
import kotlinx.android.synthetic.main.nav_header_navigation_drawer.*
import kotlinx.android.synthetic.main.nav_header_navigation_drawer.view.*

class NavigationDrawer : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,PlantsAdapter.OnPlantsSelectedListener{
    override fun onDrawerClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNavClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPlantsSelected(plant: DocumentSnapshot?) {

        val intent  = Intent(this, PlantList2::class.java)
        val plantName: String = plant?.get("name") as String
        val plantUrl: String = plant?.get("url") as String
        val plantDesc: String = plant?.get("desc") as String

        intent.putExtra("PLANT_NAME",plantName)
        intent.putExtra("URL",plantUrl)
        intent.putExtra("Text",plantDesc)

        startActivity(intent)
    }



    val plantList = DbStore.getPlantdata()
    var filteredList = ArrayList<Plant>()
//    var adapter: RecyclerViewAdapter? = null
    private val TAGO = "PlantList"
    var email = ""
    private var mAdapter: PlantsAdapter? = null
    private var mPlantsRecycler: RecyclerView? = null

    lateinit private var mFirestore: FirebaseFirestore

    private var mQuery: Query? = null


    private fun initFirestore() {
        // TODO(developer): Implement
        mFirestore = FirebaseFirestore.getInstance()
        // Get the 50 highest rated restaurants
        if(mFirestore != null)
        mQuery = mFirestore.collection("plants")
                .limit(50L)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Mail us @ abc@plantworld.com", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

       val header = navView.getHeaderView(0)
        var eid =  intent.extras["email"].toString()

        val email = findViewById<TextView>(R.id.emailText)
        header.emailText.setText(eid)



        navView.setNavigationItemSelectedListener(this)
        initImageBitmaps()
        handleIntent(intent)
        initFirestore()
        initRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        // Start listening for Firestore updates
        if (mAdapter != null) {
            mAdapter?.startListening()
        }
    }

    public override fun onStop() {
        super.onStop()
        if (mAdapter != null) {
            mAdapter?.stopListening()
        }
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        (menu.findItem(R.id.addPlants)).setOnMenuItemClickListener {
            onAddItemsClicked()
        }
        return true
    }

    private fun onAddItemsClicked() : Boolean {
        // Get a reference to the restaurants collection
        val plants = mFirestore.collection("plants")

        DbStore.getPlantdata().forEach {

            plants.add(it)

        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                val intent = Intent("android.media.action.IMAGE_CAPTURE")
                startActivity(intent)
                Toast.makeText(this, "Scan a plant !!", Toast.LENGTH_LONG).show()

            }
            R.id.nav_gallery, R.id.nav_tools, R.id.nav_send ,R.id.nav_slideshow, R.id.nav_share   -> {

                Toast.makeText(this,"Navigation Button clicked",Toast.LENGTH_LONG).show()
            }


        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
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
            val names = this.plantList.filter { n -> n.name.contains(query,true)

            }

            filteredList.clear()
            names.forEach { n -> filteredList.add(n) }
//            adapter?.notifyDataSetChanged()
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


//        initRecyclerView()

    }
//
//    private fun initRecyclerView() {
//        val recycler = recycler_view
//        this.filteredList = plantList;
//        adapter = RecyclerViewAdapter(  filteredList,  this.applicationContext)
//        recycler.adapter = adapter;
//        recycler.setLayoutManager(LinearLayoutManager(this))
//    }


    private fun initRecyclerView() {
        if (mQuery == null) {
            Log.w(TAGO, "No query, not initializing RecyclerView")
        }

        mAdapter = object : PlantsAdapter(applicationContext,mQuery, this) {

            override fun onDataChanged() {
                // Show/hide content if the query returns empty.


            }

           override fun onError(e: FirebaseFirestoreException) {
                // Show a snackbar on errors
                Snackbar.make(findViewById(android.R.id.content),
                        "Error: check logs for info.", Snackbar.LENGTH_LONG).show()
            }
        }
        val recycler = recycler_view

        recycler.setLayoutManager(LinearLayoutManager(this))
        recycler.setAdapter(mAdapter)
    }

     fun onClick(v: View) {
        when (v.id) {
            R.id.nav_view-> onNavClicked()
            R.id.drawer_layout -> onDrawerClicked()
//            View.getId(R.id.parent_layout)
        }

    }





}
