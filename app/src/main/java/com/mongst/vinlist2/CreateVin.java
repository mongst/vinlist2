package com.mongst.vinlist2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateVin extends AppCompatActivity {

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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Save to database
            }
        });
    }
}

