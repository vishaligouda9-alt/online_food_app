package com.foodapp.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.MenuDAO;
import com.foodapp.DBUtil.DBConnection;
import com.foodapp.model.Menu;

/*
 * Implements all database operations
 * related to Menu.
 */

public class MenuDAOImpl implements MenuDAO {

    private Connection connection;

    public MenuDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public int addMenu(Menu menu) {

        String query = "INSERT INTO menu(restaurant_id,item_name,description,price,is_available) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, menu.getRestaurantId());
            ps.setString(2, menu.getItemName());
            ps.setString(3, menu.getDescription());
            ps.setDouble(4, menu.getPrice());
            ps.setBoolean(5, menu.isAvailable());

            return ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Menu getMenuById(int menuId) {

        String query = "SELECT * FROM menu WHERE menu_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, menuId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Menu menu = new Menu();

                menu.setMenuId(rs.getInt("menu_id"));
                menu.setRestaurantId(rs.getInt("restaurant_id"));
                menu.setItemName(rs.getString("item_name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setAvailable(rs.getBoolean("is_available"));

                return menu;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Menu> getMenuByRestaurantId(int restaurantId) {

        List<Menu> menuList = new ArrayList<>();

        String query = "SELECT * FROM menu WHERE restaurant_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Menu menu = new Menu();

                menu.setMenuId(rs.getInt("menu_id"));
                menu.setRestaurantId(rs.getInt("restaurant_id"));
                menu.setItemName(rs.getString("item_name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setAvailable(rs.getBoolean("is_available"));

                menuList.add(menu);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return menuList;
    }

    @Override
    public int updateMenu(Menu menu) {

        String query = "UPDATE menu SET item_name=?, description=?, price=?, is_available=? WHERE menu_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, menu.getItemName());
            ps.setString(2, menu.getDescription());
            ps.setDouble(3, menu.getPrice());
            ps.setBoolean(4, menu.isAvailable());
            ps.setInt(5, menu.getMenuId());

            return ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteMenu(int menuId) {

        String query = "DELETE FROM menu WHERE menu_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, menuId);

            return ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }
}