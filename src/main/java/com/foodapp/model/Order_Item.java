package com.foodapp.model;

/*
 * OrderItem Model Class
 *
 * Represents one record from
 * the order_item table.
 */

public class Order_Item {

    // Instance Variables

    private int orderItemId;
    private int orderId;
    private int menuId;
    private int quantity;
    private double itemPrice;

    // Default Constructor

    public Order_Item() {

    }

    // Parameterized Constructor (Without ID)

    public Order_Item(int orderId,
                     int menuId,
                     int quantity,
                     double itemPrice) {

        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.itemPrice = itemPrice;

    }

    // Parameterized Constructor (With ID)

    public Order_Item(int orderItemId,
                     int orderId,
                     int menuId,
                     int quantity,
                     double itemPrice) {

        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.itemPrice = itemPrice;

    }

    // Getters

    public int getOrderItemId() {
        return orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getMenuId() {
        return menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    // Setters

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {

        return "OrderItem [orderItemId=" + orderItemId +
                ", orderId=" + orderId +
                ", menuId=" + menuId +
                ", quantity=" + quantity +
                ", itemPrice=" + itemPrice + "]";

    }

}