package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Menu;

/*
 * DAO Interface for Menu table.
 */

public interface MenuDAO {

    // Add menu item
    int addMenu(Menu menu);

    // Get menu by menu ID
    Menu getMenuById(int menuId);

    // Get all menu items of a restaurant
    List<Menu> getMenuByRestaurantId(int restaurantId);

    // Update menu item
    int updateMenu(Menu menu);

    // Delete menu item
    int deleteMenu(int menuId);

}