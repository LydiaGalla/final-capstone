package com.techelevator.model;

public class CustomCake {

    private Integer customCakeId;

    private Integer cakeSizeId;

    private Integer cakeFlavorId;

    private Integer cakeFrostingId;

    private Integer cakeFillingId;

    private Integer cakeStyleId;

    private String extras;

    private Integer priceId;

    public Integer getCustomCakeId() {
        return customCakeId;
    }

    public void setCustomCakeId(Integer customCakeId) {
        this.customCakeId = customCakeId;
    }

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

    public CustomCake() {

    }

    public CustomCake(Integer customCakeId, Integer cakeSizeId, Integer cakeFlavorId, Integer cakeFrostingId, Integer cakeFillingId, Integer cakeStyleId, String extras, Integer priceId) {
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
