package com.foodapp.dao;

import java.util.List;
import com.foodapp.model.User;

/*
 * DAO Interface
 * Declares all database operations.
 */

public interface UserDAO {

    // Insert user
    int addUser(User user);

    // Get user by ID
    User getUserById(int userId);

    // Get user by email
    User getUserByEmail(String email);

    // Get all users
    List<User> getAllUsers();

    // Update user
    int updateUser(User user);

    // Delete user
    int deleteUser(int userId);

}