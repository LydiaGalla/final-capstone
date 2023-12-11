package com.techelevator.model;

public class CustomCakeDto {
    private Integer cakeSizeId;

    private Integer cakeFlavorId;

    private Integer cakeFrostingId;

    private Integer cakeFillingId;

    private Integer cakeStyleId;

    private String extras;

    private Integer priceId;

    public Integer getCakeSizeId() {
        return cakeSizeId;
    }

    public void setCakeSizeId(Integer cakeSizeId) {
        this.cakeSizeId = cakeSizeId;
    }

    public Integer getCakeFlavorId() {
        return cakeFlavorId;
    }

    public void setCakeFlavorId(Integer cakeFlavorId) {
        this.cakeFlavorId = cakeFlavorId;
    }

    public Integer getCakeFrostingId() {
        return cakeFrostingId;
    }

    public void setCakeFrostingId(Integer cakeFrostingId) {
        this.cakeFrostingId = cakeFrostingId;
    }

    public Integer getCakeFillingId() {
        return cakeFillingId;
    }

    public void setCakeFillingId(Integer cakeFillingId) {
        this.cakeFillingId = cakeFillingId;
    }

    public Integer getCakeStyleId() {
        return cakeStyleId;
    }

    public void setCakeStyleId(Integer cakeStyleId) {
        this.cakeStyleId = cakeStyleId;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
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
