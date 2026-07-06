package com.foodapp.model;

import java.sql.Timestamp;

/*
 * Order Model Class
 *
 * This class represents one record
 * from the orders table.
 */

public class Order {

    // Instance Variables

    private int orderId;
    private int userId;
    private int restaurantId;
    private double totalAmount;
    private String status;
    private String paymentMode;
    private Timestamp orderDate;

    // Default Constructor

    public Order() {

    }

    // Parameterized Constructor (Without Order ID)

    public Order(int userId, int restaurantId,
            double totalAmount, String status,
            String paymentMode, Timestamp orderDate) {

        this.userId = userId;
        this.restaurantId = restaurantId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMode = paymentMode;
        this.orderDate = orderDate;
    }

    // Parameterized Constructor (With Order ID)

    public Order(int orderId, int userId,
            int restaurantId, double totalAmount,
            String status, String paymentMode,
            Timestamp orderDate) {

        this.orderId = orderId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMode = paymentMode;
        this.orderDate = orderDate;
    }

    // Getters

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    // Setters

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    // toString()

    @Override
    public String toString() {

        return "Order [orderId=" + orderId +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                ", paymentMode=" + paymentMode +
                ", orderDate=" + orderDate + "]";

    }

}