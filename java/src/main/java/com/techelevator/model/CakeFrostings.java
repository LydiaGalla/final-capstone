package com.techelevator.model;

public class CakeFrostings {

    private Integer frostingId;

    private String frostingName;

    private boolean isAvailable;

    public Integer getFrostingId() {
        return frostingId;
    }

    public void setFrostingId(Integer frostingId) {
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

    public CakeFrostings(Integer frostingId, String frostingName, boolean isAvailable) {
        this.frostingId = frostingId;
        this.frostingName = frostingName;
        this.isAvailable = isAvailable;
    }

}
