package com.mongst.vinlist2;

import android.arch.persistence.room.Entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@Entity
public class Vin {

    public Vin(String createVin, String notesVin) {
        this.createVin = createVin;
        this.notesVin = notesVin;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "enter_vin")
    private String createVin;

    @ColumnInfo(name = "notes_vin")
    private String notesVin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateVin() {
        return createVin;
    }

    public void setCreateVin(String createVin) {
        this.createVin = createVin;
    }

    public String getNotesVin() {
        return notesVin;
    }

    public void setNotesVin(String notesVin) {
        this.notesVin = notesVin;
    }
}
