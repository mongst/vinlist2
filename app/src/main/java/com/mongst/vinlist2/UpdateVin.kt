package com.mongst.vinlist2


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room


// Update vin page

class UpdateVin : AppCompatActivity() {

    lateinit var updateVin: EditText
    lateinit var updateNotes: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_vin)

        updateVin = findViewById(R.id.update_vin)
        updateNotes = findViewById(R.id.update_notes)
        button = findViewById(R.id.button)

        val db = Room.databaseBuilder<AppDatabase>(applicationContext, AppDatabase::class.java!!, "production")
                .allowMainThreadQueries()
                .build()


    }

    companion object {

        internal val TAG = UpdateVin::class.java!!.getSimpleName()
    }

}
