package com.mongst.vinlist2;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface VinDao {
    @Query("SELECT * FROM vin")
    List<Vin> getAllVins();

    @Insert
    void insertAll(Vin... vins);
}
