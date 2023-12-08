package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class StandardCakeOrderDto {
    private int standardCakeId;

    private String firstName;

    private String lastName;

    private String phone;

    private LocalDate dueDate;

    private LocalTime dueTime;

    private String writing;

    private String status;

    private BigDecimal total;

    public int getStandardCakeId() {
        return standardCakeId;
    }

    public void setStandardCakeId(int standardCakeId) {
        this.standardCakeId = standardCakeId;
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

    @Override
    public String toString() {
        return "StandardCakeOrderDto{" +
                "standardCakeId=" + standardCakeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", dueDate=" + dueDate +
                ", dueTime=" + dueTime +
                ", writing='" + writing + '\'' +
                ", status='" + status + '\'' +
                ", total=" + total +
                '}';
    }
}
