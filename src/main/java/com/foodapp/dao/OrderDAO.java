package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Order;

/*
 * OrderDAO Interface
 *
 * Contains all CRUD method declarations.
 */

public interface OrderDAO {

    // Insert a new order
    int addOrder(Order order);

    // Fetch order using order ID
    Order getOrderById(int order_Id);

    // Fetch all orders of a user
    List<Order> getOrdersByUserId(int userId);

    // Update order
    int updateOrder(Order order);

    // Delete order
    int deleteOrder(int order_Id);

}
