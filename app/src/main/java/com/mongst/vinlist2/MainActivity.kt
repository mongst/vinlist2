package com.mongst.vinlist2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mongst.vinlist2.data.AppDatabase

lateinit var db: AppDatabase

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        db = Room.databaseBuilder(this, AppDatabase::class.java, "VinDatabase")
                .allowMainThreadQueries()
                .build()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val launchUpdateVin = { id: Int? ->
            val intent = Intent(this, UpdateVin::class.java)
            intent.putExtra("vinId", id)
            startActivity(intent)
        }

        recyclerView.adapter  = VinAdapter(launchUpdateVin)


        fab = findViewById(R.id.fab)
        fab.setOnClickListener { startActivity(Intent(this, UpdateVin::class.java)) }
    }

}
