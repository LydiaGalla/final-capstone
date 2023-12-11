package com.techelevator.model;

import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;

public class StandardCake {
    private Integer standardCakeId;

    private String cakeName;

    private String description;

    private BigDecimal price;

    private boolean isAvailable;

    public Integer getStandardCakeId() {
        return standardCakeId;
    }

    public void setStandardCakeId(Integer standardCakeId) {
        this.standardCakeId = standardCakeId;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public StandardCake() {

    }

    public StandardCake(Integer standardCakeId, String cakeName, String description, BigDecimal price, boolean isAvailable) {
        this.standardCakeId = standardCakeId;
        this.cakeName = cakeName;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
    }

}
