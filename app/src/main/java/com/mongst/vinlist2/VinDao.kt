package com.mongst.vinlist2

import androidx.room.*
import androidx.room.Update

@Dao
interface VinDao {

    @Query("SELECT * FROM Vin")
    fun allVins(): List<Vin>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vins: Vin)

    @Update
    fun updateVin(vararg vins: Vin)

    @Delete
    fun deleteVin(vararg vins: Vin)


}
