package com.mongst.vinlist2;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import java.util.List;

import androidx.room.Room;

public class Activity2 extends AppCompatActivity {

    private static final String TAG = "Activity2";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;
//    ArrayList<Vin> vins; **out at 51:37
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);


//        vins = new ArrayList<>();

//        this section commented out 40:20

//        for (int i = 0; i < 10; i++) {
//            Vin vin = new Vin(createVin: "12345",)
//            vins.add("01234 #" + i);
//        }

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        List<Vin> vins = db.vinDao().getAllVins();

        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        adapter = new VinAdapter(vins);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, UpdateVin.class));
            }
        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, CreateVin.class));
            }
        });
    }

}
