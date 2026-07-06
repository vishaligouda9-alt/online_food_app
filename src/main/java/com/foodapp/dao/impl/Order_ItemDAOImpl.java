package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.Order_ItemDAO;
import com.foodapp.DBUtil.DBConnection;
import com.foodapp.model.Order_Item;

/*
 * OrderItemDAOImpl
 *
 * Implements all database operations
 * for the order_item table.
 */

public class Order_ItemDAOImpl implements Order_ItemDAO {

    // Database connection

    private Connection connection;

    // Constructor

    public Order_ItemDAOImpl() {

        connection = DBConnection.getConnection();

    }

    /*
     * Insert a new order item.
     */

    @Override
    public int addOrder_Item(Order_Item order_Item) {

        String sql = "INSERT INTO order_item(order_id,menu_id,quantity,item_price) VALUES(?,?,?,?)";

        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, order_Item.getOrderId());
            pstmt.setInt(2, order_Item.getMenuId());
            pstmt.setInt(3, order_Item.getQuantity());
            pstmt.setDouble(4, order_Item.getItemPrice());

            return pstmt.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;
    }


    /*
     * Get all items belonging to one order.
     */

    @Override
    public List<Order_Item> getOrderItemsByOrderId(int orderId) {

        List<Order_Item> itemList = new ArrayList<>();

        String query =
        "SELECT * FROM order_item WHERE order_id=?";

        try {

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Order_Item item = new Order_Item();

                item.setOrderItemId(rs.getInt("order_item_id"));
                item.setOrderId(rs.getInt("order_id"));
                item.setMenuId(rs.getInt("menu_id"));
                item.setQuantity(rs.getInt("quantity"));
                item.setItemPrice(rs.getDouble("item_price"));

                itemList.add(item);

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return itemList;

    }

    /*
     * Update quantity and item price.
     */

    @Override
    public int updateOrderItem(Order_Item orderItem) {

        String query =
        "UPDATE order_item SET quantity=?, item_price=? WHERE order_item_id=?";

        try {

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setInt(1, orderItem.getQuantity());
            ps.setDouble(2, orderItem.getItemPrice());
            ps.setInt(3, orderItem.getOrderItemId());

            return ps.executeUpdate();

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;

    }

    /*
     * Delete one order item.
     */

    @Override
    public int deleteOrderItem(int orderItemId) {

        String query =
        "DELETE FROM order_item WHERE order_item_id=?";

        try {

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setInt(1, orderItemId);

            return ps.executeUpdate();

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;

    }

}