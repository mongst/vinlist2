package com.mongst.vinlist2;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


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

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        button.setOnClickListener((v) ->) {
            Log.d(TAG, "onCreate: updateVin: " + updateVin.getText().toString());
            Update update = new Update(updateVin.getText().toString(), updateNotes.getText().toString());
            db.vinDao().insertAll(update);
            startActivity(new Intent(UpdateVin.this, Activity2.class));
        };
    }

}
