package com.techelevator.model;

public class CakeStyle {

    private Integer styleId;

    private String styleName;

    private boolean isAvailable;

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
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

    public CakeStyle(Integer styleId, String styleName, boolean isAvailable) {
        this.styleId = styleId;
        this.styleName = styleName;
        this.isAvailable = isAvailable;
    }
}
