package com.mongst.vinlist2;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface VinDao {

    @Query("SELECT * FROM Vin")
    List<Vin> getAllVins();

    @Insert
    void insertAll(Vin vins);

      @Delete
    void deleteVin(Vin... vins);


}
