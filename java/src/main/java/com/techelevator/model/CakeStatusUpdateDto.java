package com.techelevator.model;

public class CakeStatusUpdateDto {

    private String CakeStatus;

    public CakeStatusUpdateDto(){

    }

    public CakeStatusUpdateDto(String cakeStatus) {
        CakeStatus = cakeStatus;
    }

    public String getCakeStatus() {
        return CakeStatus;
    }

    public void setCakeStatus(String cakeStatus) {
        CakeStatus = cakeStatus;
    }
}
