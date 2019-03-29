package com.mongst.vinlist2;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


// Update vin page

public class UpdateVin extends AppCompatActivity {

    final static String TAG = UpdateVin.class.getSimpleName();

    EditText updateVin;
    EditText updateNotes;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_vin);

        updateVin = findViewById(R.id.update_vin);
        updateNotes = findViewById(R.id.update_notes);
        button = findViewById(R.id.button);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();


    }

}
