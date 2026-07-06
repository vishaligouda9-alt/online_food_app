package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * DeleteCartServlet
 *
 * Removes an item from the cart.
 */

@WebServlet("/deleteCart")
public class DeleteCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Read menu ID
        int menuId = Integer.parseInt(request.getParameter("menuId"));

        // Get session
        HttpSession session = request.getSession();

        // Get cart
        Cart cart = (Cart) session.getAttribute("cart");

        // Remove item
        if (cart != null) {

            cart.removeItem(menuId);

        }

        // Redirect to cart page
        response.sendRedirect("cart.jsp");

    }

}