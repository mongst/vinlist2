package com.mongst.vinlist2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var button: Button? = null

    //    Button sends user to Activity2 "list" page
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById<View>(R.id.button) as Button
        button!!.setOnClickListener { openActivity2() }
    }

    fun openActivity2() {
        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }
}

