package com.mongst.vinlist2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface VinDao {
    @Query("SELECT * FROM vin")
    List<Vin> getAllVins();

    @Insert
    void insertAll(Vin... vins);
}
