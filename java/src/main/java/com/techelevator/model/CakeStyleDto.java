package com.techelevator.model;

public class CakeStyleDto {
    private String styleName;

    private boolean isAvailable;

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "CakeStyleDto{" +
                "styleName='" + styleName + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
