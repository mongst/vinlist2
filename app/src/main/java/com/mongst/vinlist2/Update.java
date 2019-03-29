package com.mongst.vinlist2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Update {

    public Update(String updateVin, String updateNotes) {
        this.updateVin = updateVin;
        this.updateNotes = updateNotes;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "update_vin")
    private String updateVin;

    @ColumnInfo(name = "update_notes")
    private String updateNotes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUpdateVin() {
        return updateVin;
    }

    public void setCreateVin(String updateVin) {
        this.updateVin = updateVin;
    }

    public String getNotesVin() {
        return updateNotes;
    }

    public void setNotesVin(String updateNotes) {
        this.updateNotes = updateNotes;
    }
}

