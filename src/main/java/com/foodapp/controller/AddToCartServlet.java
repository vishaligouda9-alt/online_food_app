package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.model.Cart;
import com.foodapp.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * AddToCartServlet
 *
 * Adds a menu item to the user's cart.
 */

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Read menu details from the form
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        String itemName = request.getParameter("itemName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Create CartItem object
        CartItem item = new CartItem(menuId, itemName, price, quantity);

        // Get current session
        HttpSession session = request.getSession();

        // Get cart from session
        Cart cart = (Cart) session.getAttribute("cart");

        // Create new cart if it doesn't exist
        if (cart == null) {
            cart = new Cart();
        }

        // Add item to cart
        cart.addItem(item);

        // Store updated cart back into session
        session.setAttribute("cart", cart);

        // Redirect to Cart page
        response.sendRedirect("cart.jsp");
    }
}