package com.mongst.vinlist2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Vin")
data class Vin (
        @PrimaryKey(autoGenerate = true)
        val id: Int?,
        val stringVin: String,
        val notesVin: String
)
