package com.mongst.vinlist2;


public class Vin {

    public Vin(String createVin, String notesVin) {
        this.createVin = createVin;
        this.notesVin = notesVin;
    }


    private int id;

    private String createVin;

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
