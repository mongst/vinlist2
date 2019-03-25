package com.mongst.vinlist2;

import android.arch.persistence.room.Database;

import androidx.room.RoomDatabase;

@Database(entities = {Vin.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VinDao vinDao();
}
