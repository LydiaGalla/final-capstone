package com.techelevator.model;

public class CustomCake {

    private int customCakeId;

    private int cakeSizeId;

    private int cakeFlavorId;

    private int cakeFrostingId;

    private int cakeFillingId;

    private int cakeStyleId;

    private String extras;

    private int priceId;

    public int getCustomCakeId() {
        return customCakeId;
    }

    public void setCustomCakeId(int customCakeId) {
        this.customCakeId = customCakeId;
    }

    public int getCakeSizeId() {
        return cakeSizeId;
    }

    public void setCakeSizeId(int cakeSizeId) {
        this.cakeSizeId = cakeSizeId;
    }

    public int getCakeFlavorId() {
        return cakeFlavorId;
    }

    public void setCakeFlavorId(int cakeFlavorId) {
        this.cakeFlavorId = cakeFlavorId;
    }

    public int getCakeFrostingId() {
        return cakeFrostingId;
    }

    public void setCakeFrostingId(int cakeFrostingId) {
        this.cakeFrostingId = cakeFrostingId;
    }

    public int getCakeFillingId() {
        return cakeFillingId;
    }

    public void setCakeFillingId(int cakeFillingId) {
        this.cakeFillingId = cakeFillingId;
    }

    public int getCakeStyleId() {
        return cakeStyleId;
    }

    public void setCakeStyleId(int cakeStyleId) {
        this.cakeStyleId = cakeStyleId;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public CustomCake() {

    }

    public CustomCake(int customCakeId, int cakeSizeId, int cakeFlavorId, int cakeFrostingId, int cakeFillingId, int cakeStyleId, String extras, int priceId) {
        this.customCakeId = customCakeId;
        this.cakeSizeId = cakeSizeId;
        this.cakeFlavorId = cakeFlavorId;
        this.cakeFrostingId = cakeFrostingId;
        this.cakeFillingId = cakeFillingId;
        this.cakeStyleId = cakeStyleId;
        this.extras = extras;
        this.priceId = priceId;
    }
}
