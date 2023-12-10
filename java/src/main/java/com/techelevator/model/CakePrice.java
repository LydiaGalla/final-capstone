package com.techelevator.model;

import java.math.BigDecimal;

public class CakePrice {

    private Integer priceId;

    private BigDecimal cupcakeSingle;

    private BigDecimal cupcakeBakersDozen;

    private BigDecimal smallCake;

    private BigDecimal largeCake;

    private BigDecimal smallCakeCustom;

    private BigDecimal largeCakeCustom;

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public BigDecimal getCupcakeSingle() {
        return cupcakeSingle;
    }

    public void setCupcakeSingle(BigDecimal cupcakeSingle) {
        this.cupcakeSingle = cupcakeSingle;
    }

    public BigDecimal getCupcakeBakersDozen() {
        return cupcakeBakersDozen;
    }

    public void setCupcakeBakersDozen(BigDecimal cupcakeBakersDozen) {
        this.cupcakeBakersDozen = cupcakeBakersDozen;
    }

    public BigDecimal getSmallCake() {
        return smallCake;
    }

    public void setSmallCake(BigDecimal smallCake) {
        this.smallCake = smallCake;
    }

    public BigDecimal getLargeCake() {
        return largeCake;
    }

    public void setLargeCake(BigDecimal largeCake) {
        this.largeCake = largeCake;
    }

    public BigDecimal getSmallCakeCustom() {
        return smallCakeCustom;
    }

    public void setSmallCakeCustom(BigDecimal smallCakeCustom) {
        this.smallCakeCustom = smallCakeCustom;
    }

    public BigDecimal getLargeCakeCustom() {
        return largeCakeCustom;
    }

    public void setLargeCakeCustom(BigDecimal largeCakeCustom) {
        this.largeCakeCustom = largeCakeCustom;
    }

    public CakePrice() {

    }

    public CakePrice(Integer priceId, BigDecimal cupcakeSingle, BigDecimal cupcakeBakersDozen, BigDecimal smallCake, BigDecimal largeCake, BigDecimal smallCakeCustom, BigDecimal largeCakeCustom) {
        this.priceId = priceId;
        this.cupcakeSingle = cupcakeSingle;
        this.cupcakeBakersDozen = cupcakeBakersDozen;
        this.smallCake = smallCake;
        this.largeCake = largeCake;
        this.smallCakeCustom = smallCakeCustom;
        this.largeCakeCustom = largeCakeCustom;
    }
}
