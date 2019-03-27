package com.mongst.vinlist2;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


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

        button.setOnClickListener((v) -> {
            Log.d(TAG, "onCreate: updateVin: " + updateVin.getText().toString());
            Update update = new Update(updateVin.getText().toString(), updateNotes.getText().toString());
            db.vinDao().insertAll(vin);
            startActivity(new Intent(UpdateVin.this, Activity2.class));
        });
    }

}
