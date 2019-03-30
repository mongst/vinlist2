package com.mongst.vinlist2.data


import androidx.room.Database
import androidx.room.RoomDatabase
import com.mongst.vinlist2.data.Vin
import com.mongst.vinlist2.data.VinDao

@Database(entities = [Vin::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vinDao(): VinDao
}
