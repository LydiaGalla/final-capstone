package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class CakeOrder {

    private int orderId;

    private int standardCakeId;

    private int customCakeId;

    private String firstName;

    private String lastName;

    private String phone;

    private LocalDate dueDate;

    private LocalTime dueTime;

    private String writing;

    private String status;

    private BigDecimal total;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public CakeOrder() {

    }

    public CakeOrder(int orderId, int standardCakeId, int customCakeId, String firstName, String lastName, String phone, LocalDate dueDate, LocalTime dueTime, String writing, String status, BigDecimal total) {
        this.orderId = orderId;
        this.standardCakeId = standardCakeId;
        this.customCakeId = customCakeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.writing = writing;
        this.status = status;
        this.total = total;
    }
}
