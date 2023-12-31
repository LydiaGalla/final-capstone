package com.techelevator.model;

public class CakeSizes {

    private Integer sizeId;

    private String sizeName;

    private boolean isAvailable;

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

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

    public CakeSizes() {

    }

    public CakeSizes(Integer sizeId, String sizeName, boolean isAvailable) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.isAvailable = isAvailable;
    }
}
