package com.techelevator.model;

public class CakeFillingDto {
    private String fillingName;

    private boolean isAvailable;

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

    @Override
    public String toString() {
        return "CakeFillingDto{" +
                "fillingName='" + fillingName + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

}
