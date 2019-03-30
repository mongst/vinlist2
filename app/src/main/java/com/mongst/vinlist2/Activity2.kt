package com.mongst.vinlist2

import android.content.Intent
import android.os.Bundle

import com.google.android.material.floatingactionbutton.FloatingActionButton

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlin.concurrent.thread

class Activity2 : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecyclerView.Adapter<*>
    lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recycler_view)


        val db = Room.databaseBuilder<AppDatabase>(applicationContext, AppDatabase::class.java, "production")
                .allowMainThreadQueries()
                .build()

        thread {
            db.vinDao().insertAll(Vin(1, "3249754y503fdsklh", ""))
        }

        val vins = db.vinDao().allVins()

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = VinAdapter(vins)
        recyclerView.adapter = adapter

        recyclerView.setOnClickListener { v -> startActivity(Intent(this@Activity2, UpdateVin::class.java)) }

        //        floating action button "add"

        fab = findViewById(R.id.fab)
        fab.setOnClickListener { v -> startActivity(Intent(this@Activity2, CreateVin::class.java)) }
    }

}
