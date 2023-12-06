package com.techelevator.model;

public class CakeStyle {

    private int styleId;

    private String styleName;

    private boolean isAvailable;

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

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

    public CakeStyle() {

    }

    public CakeStyle(int styleId, String styleName, boolean isAvailable) {
        this.styleId = styleId;
        this.styleName = styleName;
        this.isAvailable = isAvailable;
    }
}
