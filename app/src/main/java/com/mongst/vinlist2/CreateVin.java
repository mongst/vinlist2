package com.mongst.vinlist2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class CreateVin extends AppCompatActivity {

    final static String TAG = CreateVin.class.getSimpleName();

    EditText createVin;
    EditText notesVin;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_vin);

        createVin = findViewById(R.id.enter_vin);
        notesVin = findViewById(R.id.notes_vin);
        button = findViewById(R.id.button);

//        database
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        button.setOnClickListener((v) -> {
            Log.d(TAG, "onClick: createVin: " + createVin.getText().toString());

            Vin vin = new Vin(createVin.getText().toString(), notesVin.getText().toString());
            db.vinDao().insertAll(vin);
            startActivity(new Intent(CreateVin.this, Activity2.class));
        });
    }
}

