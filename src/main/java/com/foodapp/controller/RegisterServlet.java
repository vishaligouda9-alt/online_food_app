package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.dao.impl.UserDAOImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * RegisterServlet
 *
 * This servlet receives user details from signup.jsp
 * and saves the new user into the database.
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /*
     * Handles POST request from signup.jsp
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Read form values

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // Create User object

        User user = new User(fullName, email, password, phone, address);

        // Create DAO object

        UserDAOImpl dao = new UserDAOImpl();

        // Insert user into database
        User existingUser = dao.getUserByEmail(email);

        if (existingUser != null) {
            response.getWriter().println("<h2>Email already exists!</h2>");
            return;
        }

        int result = dao.addUser(user);

        // Check insertion status

        if (result > 0) {

            // Registration successful
            response.sendRedirect("login.jsp");

        } else {

            // Registration failed
            response.getWriter().println("<h2>Registration Failed!</h2>");

        }

    }

}