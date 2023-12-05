package com.techelevator.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class CakeOrder {

    private int orderId;

    private int standardCakeId;

    private int customCakeId;

    private LocalDate dueDate;

    private LocalTime dueTime;

    private String writing;

    private String status;

    private int quantity;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getStandardCakeId() {
        return standardCakeId;
    }

    public void setStandardCakeId(int standardCakeId) {
        this.standardCakeId = standardCakeId;
    }

    public int getCustomCakeId() {
        return customCakeId;
    }

    public void setCustomCakeId(int customCakeId) {
        this.customCakeId = customCakeId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalTime getDueTime() {
        return dueTime;
    }

    public void setDueTime(LocalTime dueTime) {
        this.dueTime = dueTime;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CakeOrder() {

    }

    public CakeOrder(int orderId, int standardCakeId, int customCakeId, LocalDate dueDate, LocalTime dueTime, String writing, String status, int quantity) {
        this.orderId = orderId;
        this.standardCakeId = standardCakeId;
        this.customCakeId = customCakeId;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.writing = writing;
        this.status = status;
        this.quantity = quantity;
    }
}
