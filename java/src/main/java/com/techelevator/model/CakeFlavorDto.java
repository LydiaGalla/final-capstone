package com.techelevator.model;

public class CakeFlavorDto {

    private String flavorName;

    private boolean isAvailable;

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

    @Override
    public String toString() {
        return "CakeFlavorDto{" +
                "flavorName='" + flavorName + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
