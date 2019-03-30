package com.mongst.vinlist2.data

import androidx.room.*
import androidx.room.Update
import com.mongst.vinlist2.data.Vin

@Dao
interface VinDao {

    @Query("SELECT * FROM Vin")
    fun getAllVins(): List<Vin>

    @Query("SELECT * FROM Vin WHERE id = :id")
    fun getVinById(id: Int): Vin

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVin(vins: Vin): Long

    @Delete
    fun deleteVin(vins: Vin)


}
