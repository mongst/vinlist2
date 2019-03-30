package com.mongst.vinlist2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Vin")
data class Vin (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val createVin: String,
    val notesVin: String
)




//@Entity
//class Vin internal constructor(@field:ColumnInfo(name = "enter_vin")
//          internal val createVin: String, @field:ColumnInfo(name = "notes_vin")
//
//
//                               //    public void setCreateVin(String createVin) {
//                               //        this.createVin = createVin;
//                               //    }
//
//                               internal val notesVin: String) {
//
//    @PrimaryKey(autoGenerate = true)
//    var id: Int = 0
//
//    //    public void setNotesVin(String notesVin) {
//    //        this.notesVin = notesVin;
//    //    }
//}
