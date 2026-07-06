package com.foodapp.model;

import java.sql.Timestamp;

/*
 * Model class for User table.
 * This class stores user information.
 */
public class User {

    // Instance variables
    private int userId;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Timestamp createdAt;

    // Default Constructor
    public User() {

    }

    // Constructor used while signup
    public User(String fullName, String email, String password,
            String phone, String address) {

        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    // Constructor with all fields
    public User(int userId, String fullName, String email,
            String password, String phone,
            String address, Timestamp createdAt) {

        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
    }

    // Getters

    public int getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    // Setters

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {

        return "User [userId=" + userId +
                ", fullName=" + fullName +
                ", email=" + email +
                ", phone=" + phone +
                ", address=" + address +
                ", createdAt=" + createdAt + "]";
    }
}