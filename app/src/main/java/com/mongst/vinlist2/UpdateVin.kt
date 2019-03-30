package com.mongst.vinlist2


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mongst.vinlist2.data.Vin
import kotlinx.android.synthetic.main.update_vin.*

// Update vin page

class UpdateVin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_vin)

        var stringVin = ""
        var stringNotes = ""


        val vinId = intent.getIntExtra("vinId", -1)
        if (vinId != -1) {
            stringVin = db.vinDao().getVinById(vinId).stringVin
            stringNotes = db.vinDao().getVinById(vinId).notesVin
        }


        //vin text box
        val currentVin: TextView = findViewById(R.id.current_vin)
        currentVin.visibility = View.GONE
        if (vinId != -1) {
            currentVin.visibility = View.VISIBLE
            currentVin.setText(stringVin)
        }


        //notes text box
        val currentNotes: TextView = findViewById(R.id.current_notes)
        currentNotes.visibility = View.GONE
        if (vinId != -1) {
            currentNotes.visibility = View.VISIBLE
            currentNotes.setText(stringNotes)
        }

        val updateVin = findViewById<View>(R.id.update_vin) as EditText
        val updateNotes = findViewById<View>(R.id.update_notes) as EditText
        val insertButton = findViewById<Button>(R.id.insertButton)
        if (vinId == -1) {
            insertButton.text = "Insert Vin"
        } else {
            insertButton.text = "Update Vin"
        }


        //onclick button update

        insertButton.setOnClickListener {
            val pushId = if (vinId == -1) {null} else {vinId}
            val pushVin = if (updateVin.text.toString() == "") {stringVin} else {updateVin.text.toString()}
            val pushNotes = if (updateNotes.text.toString() == "") {stringNotes} else {updateNotes.text.toString()}

            if (pushVin.length < 17) {
                Toast.makeText(this,"Vin must be at least 17 characters",Toast.LENGTH_LONG).show()
            } else {
                db.vinDao().insertVin(Vin(pushId, pushVin, pushNotes))
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        deleteNotesButton.setOnClickListener{
            val pushId = if (vinId == -1) {null} else {vinId}
            val pushVin = if (updateVin.text.toString() == "") {stringVin} else {updateVin.text.toString()}
            if (pushVin.length < 17) {
                Toast.makeText(this,"Vin must be at least 17 characters",Toast.LENGTH_LONG).show()
            } else {
                db.vinDao().insertVin(Vin(pushId, pushVin, ""))
                startActivity(Intent(this, MainActivity::class.java))
            }

        }
    }
}
