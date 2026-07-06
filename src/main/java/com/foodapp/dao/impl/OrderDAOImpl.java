package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.OrderDAO;
import com.foodapp.DBUtil.DBConnection;
import com.foodapp.model.Order;

/*
 * OrderDAOImpl
 *
 * Performs all database operations
 * related to orders table.
 */

public class OrderDAOImpl implements OrderDAO {

    // Database Connection

    private Connection connection;

    // Constructor

    public OrderDAOImpl() {

        connection = DBConnection.getConnection();

    }

    /*
     * Add Order
     *
     * Returns the generated Order ID.
     */

    @Override
    public int addOrder(Order order) {

        String query = "INSERT INTO orders(user_id,restaurant_id,total_amount,status,payment_mode,order_date) VALUES(?,?,?,?,?,?)";

        try {

        	PreparedStatement ps = connection.prepareStatement(
        	        query,
        	        Statement.RETURN_GENERATED_KEYS);

        	int rows = ps.executeUpdate();

        	if (rows > 0) {

        	    ResultSet rs = ps.getGeneratedKeys();

        	    if (rs.next()) {

        	        int orderId = rs.getInt(1);
        	        System.out.println("Generated Order ID = " + orderId);
        	        return orderId;
        	    }
        	}

   

            System.out.println("No Generated Key Found");

        }
        catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
   

    }

    /*
     * Get Order By Order ID
     */

    @Override
    public Order getOrderById(int orderId) {

        String query =
        "SELECT * FROM orders WHERE order_id=?";

        try {

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Order order = new Order();

                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setRestaurantId(rs.getInt("restaurant_id"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setStatus(rs.getString("status"));
                order.setPaymentMode(rs.getString("payment_mode"));
                order.setOrderDate(rs.getTimestamp("order_date"));

                return order;

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    /*
     * Get All Orders Of A User
     */

    @Override
    public List<Order> getOrdersByUserId(int userId) {

        List<Order> orderList =
                new ArrayList<>();

        String query =
        "SELECT * FROM orders WHERE user_id=?";

        try {

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Order order = new Order();

                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setRestaurantId(rs.getInt("restaurant_id"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setStatus(rs.getString("status"));
                order.setPaymentMode(rs.getString("payment_mode"));
                order.setOrderDate(rs.getTimestamp("order_date"));

                orderList.add(order);

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return orderList;

    }

    /*
     * Update Order Status
     */

    @Override
    public int updateOrder(Order order) {

        String query =
        "UPDATE orders SET status=?, payment_mode=? WHERE order_id=?";

        try {

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setString(1, order.getStatus());

            ps.setString(2, order.getPaymentMode());

            ps.setInt(3, order.getOrderId());
            System.out.println("User ID: " + order.getUserId());
            System.out.println("Restaurant ID: " + order.getRestaurantId());
            System.out.println("Total Amount: " + order.getTotalAmount());
            System.out.println("Status: " + order.getStatus());
            System.out.println("Payment Mode: " + order.getPaymentMode());
            System.out.println("Order Date: " + order.getOrderDate());
            return ps.executeUpdate();

        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        

        return 0;

    }

    /*
     * Delete Order
     */

    @Override
    public int deleteOrder(int orderId) {

        String query =
        "DELETE FROM orders WHERE order_id=?";

        try {

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setInt(1, orderId);

            return ps.executeUpdate();

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;

    }

}


