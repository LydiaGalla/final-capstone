package com.techelevator.model;

public class CakeSizeDto {
    private String sizeName;

    private boolean isAvailable;

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "CakeSizeDto{" +
                "sizeName='" + sizeName + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
