package com.techelevator.model;

public class CustomCake {

    private int customCakeId;

    private String cakeStyle;

    private String cakeSize;

    private String cakeFlavor;

    private String frostingFlavor;

    private String fillingFlavor;

    private String extras;

    public int getCustomCakeId() {
        return customCakeId;
    }

    public void setCustomCakeId(int customCakeId) {
        this.customCakeId = customCakeId;
    }

    public String getCakeStyle() {
        return cakeStyle;
    }

    public void setCakeStyle(String cakeStyle) {
        this.cakeStyle = cakeStyle;
    }

    public String getCakeSize() {
        return cakeSize;
    }

    public void setCakeSize(String cakeSize) {
        this.cakeSize = cakeSize;
    }

    public String getCakeFlavor() {
        return cakeFlavor;
    }

    public void setCakeFlavor(String cakeFlavor) {
        this.cakeFlavor = cakeFlavor;
    }

    public String getFrostingFlavor() {
        return frostingFlavor;
    }

    public void setFrostingFlavor(String frostingFlavor) {
        this.frostingFlavor = frostingFlavor;
    }

    public String getFillingFlavor() {
        return fillingFlavor;
    }

    public void setFillingFlavor(String fillingFlavor) {
        this.fillingFlavor = fillingFlavor;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public CustomCake() {

    }

    public CustomCake(int customCakeId, String cakeStyle, String cakeSize, String cakeFlavor, String frostingFlavor, String fillingFlavor, String extras) {
        this.customCakeId = customCakeId;
        this.cakeStyle = cakeStyle;
        this.cakeSize = cakeSize;
        this.cakeFlavor = cakeFlavor;
        this.frostingFlavor = frostingFlavor;
        this.fillingFlavor = fillingFlavor;
        this.extras = extras;
    }
}
