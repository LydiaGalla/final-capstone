package com.techelevator.model;

public class CakeFlavors {

    private int flavorId;

    private String flavorName;

    private boolean isAvailable;

    public int getFlavorId() {
        return flavorId;
    }

    public void setFlavorId(int flavorId) {
        this.flavorId = flavorId;
    }

    public String getFlavorName() {
        return flavorName;
    }

    public void setFlavorName(String flavorName) {
        this.flavorName = flavorName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public CakeFlavors() {

    }

    public CakeFlavors(int flavorId, String flavorName, boolean isAvailable) {
        this.flavorId = flavorId;
        this.flavorName = flavorName;
        this.isAvailable = isAvailable;
    }
}
