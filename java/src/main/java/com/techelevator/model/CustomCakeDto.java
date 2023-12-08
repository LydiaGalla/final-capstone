package com.techelevator.model;

public class CustomCakeDto {
    private int cakeSizeId;

    private int cakeFlavorId;

    private int cakeFrostingId;

    private int cakeFillingId;

    private int cakeStyleId;

    private String extras;

    private int priceId;

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

    @Override
    public String toString() {
        return "CustomCakeDto{" +
                "cakeSizeId=" + cakeSizeId +
                ", cakeFlavorId=" + cakeFlavorId +
                ", cakeFrostingId=" + cakeFrostingId +
                ", cakeFillingId=" + cakeFillingId +
                ", cakeStyleId=" + cakeStyleId +
                ", extras='" + extras + '\'' +
                ", priceId=" + priceId +
                '}';
    }
}
