package com.mongst.vinlist2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

class CreateVin : AppCompatActivity() {

    lateinit var createVin: EditText
    lateinit var notesVin: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_vin)

        createVin = findViewById(R.id.enter_vin)
        notesVin = findViewById(R.id.notes_vin)
        button = findViewById(R.id.button)

        //        database
        val db = Room.databaseBuilder<AppDatabase>(applicationContext, AppDatabase::class.java!!, "production")
                .allowMainThreadQueries()
                .build()

        button.setOnClickListener { v ->
            Log.d(TAG, "onClick: createVin: " + createVin.text.toString())

            val vin = Vin(null, createVin.text.toString(), notesVin.text.toString())
            db.vinDao().insertAll(vin)
            startActivity(Intent(this@CreateVin, Activity2::class.java))
        }
    }

    companion object {

        internal val TAG = CreateVin::class.java.getSimpleName()
    }
}

