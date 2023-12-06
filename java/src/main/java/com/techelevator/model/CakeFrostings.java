package com.techelevator.model;

public class CakeFrostings {

    private int frostingId;

    private String frostingName;

    private boolean isAvailable;

    public int getFrostingId() {
        return frostingId;
    }

    public void setFrostingId(int frostingId) {
        this.frostingId = frostingId;
    }

    public String getFrostingName() {
        return frostingName;
    }

    public void setFrostingName(String frostingName) {
        this.frostingName = frostingName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public CakeFrostings() {

    }

    public CakeFrostings(int frostingId, String frostingName, boolean isAvailable) {
        this.frostingId = frostingId;
        this.frostingName = frostingName;
        this.isAvailable = isAvailable;
    }

}
