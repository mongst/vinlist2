package com.mongst.vinlist2;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Vin.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VinDao vinDao();
}
