package com.techelevator.model;

public class Employee {

    private int employeeId;

    private String username;

    private String passwordHash;

    private String firstname;

    private String lastname;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Employee() {

    }

    public Employee(int employeeId, String username, String passwordHash, String firstname, String lastname) {
        this.employeeId = employeeId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
