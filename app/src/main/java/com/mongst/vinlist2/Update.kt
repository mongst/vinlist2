package com.mongst.vinlist2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Update(updateVin: String, @field:ColumnInfo(name = "update_notes")
var notesVin: String?) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "update_vin")
    var updateVin: String? = null
        private set

    init {
        this.updateVin = updateVin
    }

    fun setCreateVin(updateVin: String) {
        this.updateVin = updateVin
    }
}

