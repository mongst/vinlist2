package com.mongst.vinlist2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

public class Activity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler_view);


        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        List<Vin> vins = db.vinDao().getAllVins();

        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        adapter = new VinAdapter(vins);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(v -> startActivity(new Intent(Activity2.this, UpdateVin.class)));

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> startActivity(new Intent(Activity2.this, CreateVin.class)));
    }

}
