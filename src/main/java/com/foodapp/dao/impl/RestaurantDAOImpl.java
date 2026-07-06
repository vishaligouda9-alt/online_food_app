package com.foodapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.RestaurantDAO;
import com.foodapp.DBUtil.DBConnection;
import com.foodapp.model.Restaurant;

/*
 * RestaurantDAOImpl
 * -----------------
 * Implements RestaurantDAO.
 * Performs all database operations using JDBC.
 */

public class RestaurantDAOImpl implements RestaurantDAO {

    // Database connection object
    private Connection connection;

    // Constructor
    public RestaurantDAOImpl() {

        connection = DBConnection.getConnection();

    }

    /*
     * Insert a restaurant
     */

    @Override
    public int addRestaurant(Restaurant restaurant) {

        String query = "INSERT INTO restaurant(restaurant_name,cuisine_type,address,phone,rating,image_url,is_active) VALUES(?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, restaurant.getRestaurantName());
            ps.setString(2, restaurant.getCuisineType());
            ps.setString(3, restaurant.getAddress());
            ps.setString(4, restaurant.getPhone());
            ps.setDouble(5, restaurant.getRating());
            ps.setString(6, restaurant.getImageUrl());
            ps.setBoolean(7, restaurant.isActive());

            return ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }

    /*
     * Fetch restaurant using restaurant ID
     */

    @Override
    public Restaurant getRestaurantById(int restaurantId) {

        String query = "SELECT * FROM restaurant WHERE restaurant_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Restaurant restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt("restaurant_id"));
                restaurant.setRestaurantName(rs.getString("restaurant_name"));
                restaurant.setCuisineType(rs.getString("cuisine_type"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setRating(rs.getDouble("rating"));
                restaurant.setImageUrl(rs.getString("image_url"));
                restaurant.setActive(rs.getBoolean("is_active"));

                return restaurant;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    /*
     * Fetch all restaurants
     */

    @Override
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> restaurantList = new ArrayList<>();

        String query = "SELECT * FROM restaurant";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Restaurant restaurant = new Restaurant();

                restaurant.setRestaurantId(rs.getInt("restaurant_id"));
                restaurant.setRestaurantName(rs.getString("restaurant_name"));
                restaurant.setCuisineType(rs.getString("cuisine_type"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setPhone(rs.getString("phone"));
                restaurant.setRating(rs.getDouble("rating"));
                restaurant.setImageUrl(rs.getString("image_url"));
                restaurant.setActive(rs.getBoolean("is_active"));

                restaurantList.add(restaurant);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return restaurantList;
    }

    /*
     * Update restaurant details
     */

    @Override
    public int updateRestaurant(Restaurant restaurant) {

        String query = "UPDATE restaurant SET restaurant_name=?, cuisine_type=?, address=?, phone=?, rating=?, image_url=?, is_active=? WHERE restaurant_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, restaurant.getRestaurantName());
            ps.setString(2, restaurant.getCuisineType());
            ps.setString(3, restaurant.getAddress());
            ps.setString(4, restaurant.getPhone());
            ps.setDouble(5, restaurant.getRating());
            ps.setString(6, restaurant.getImageUrl());
            ps.setBoolean(7, restaurant.isActive());
            ps.setInt(8, restaurant.getRestaurantId());

            return ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }

    /*
     * Delete restaurant using ID
     */

    @Override
    public int deleteRestaurant(int restaurantId) {

        String query = "DELETE FROM restaurant WHERE restaurant_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, restaurantId);

            return ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }

}