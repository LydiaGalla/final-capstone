package com.techelevator.model;

public class CakeFillings {

    private Integer fillingId;

    private String fillingName;

    private boolean isAvailable;

    public Integer getFillingId() {
        return fillingId;
    }

    public void setFillingId(int fillingId) {
        this.fillingId = fillingId;
    }

    public String getFillingName() {
        return fillingName;
    }

    public void setFillingName(String fillingName) {
        this.fillingName = fillingName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public CakeFillings() {

    }

    public CakeFillings(Integer fillingId, String fillingName, boolean isAvailable) {
        this.fillingId = fillingId;
        this.fillingName = fillingName;
        this.isAvailable = isAvailable;
    }

}
