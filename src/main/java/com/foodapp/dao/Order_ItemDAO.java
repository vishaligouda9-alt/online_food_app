package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Order_Item;

/*
 * DAO Interface for OrderItem.
 */

public interface Order_ItemDAO {

    // Insert new order item
    int addOrder_Item(Order_Item orderItem);

    // Get all items of an order
    List<Order_Item> getOrderItemsByOrderId(int orderId);

    // Update an order item
    int updateOrderItem(Order_Item orderItem);

    // Delete an order item
    int deleteOrderItem(int orderItemId);

}