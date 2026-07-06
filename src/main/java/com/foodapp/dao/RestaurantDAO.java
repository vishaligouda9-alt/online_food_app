package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Restaurant;

/*
 * RestaurantDAO Interface
 * -----------------------
 * Contains all CRUD method declarations.
 */

public interface RestaurantDAO {

    // Insert a restaurant
    int addRestaurant(Restaurant restaurant);

    // Get restaurant using ID
    Restaurant getRestaurantById(int restaurantId);

    // Get all restaurants
    List<Restaurant> getAllRestaurants();

    // Update restaurant details
    int updateRestaurant(Restaurant restaurant);

    // Delete restaurant
    int deleteRestaurant(int restaurantId);

}
