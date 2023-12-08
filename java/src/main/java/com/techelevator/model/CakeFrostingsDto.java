package com.techelevator.model;

public class CakeFrostingsDto {
    private String frostingName;

    private boolean isAvailable;

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

    @Override
    public String toString() {
        return "CakeFrostingsDto{" +
                "frostingName='" + frostingName + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
