package com.foodapp.controller;

import java.io.IOException;
import java.sql.Timestamp;

import com.foodapp.dao.impl.OrderDAOImpl;
import com.foodapp.dao.impl.Order_ItemDAOImpl;
import com.foodapp.model.Cart;
import com.foodapp.model.CartItem;
import com.foodapp.model.Order;
import com.foodapp.model.Order_Item;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Get logged-in user
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Get cart
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null || cart.getItems().isEmpty()) {
            response.sendRedirect("Cart.jsp");
            return;
        }

        // Read form values
        String paymentMode = request.getParameter("paymentMode");
        String address = request.getParameter("address");

        // Create Order
        Order order = new Order();

        order.setUserId(user.getUserId());

        // Replace with actual restaurant id if required
        order.setRestaurantId(1);

        order.setTotalAmount(cart.getTotalAmount());

        order.setStatus("Pending");

        order.setPaymentMode(paymentMode);

        order.setOrderDate(new Timestamp(System.currentTimeMillis()));

        // Save Order
        OrderDAOImpl orderDAO = new OrderDAOImpl();

        int orderId = orderDAO.addOrder(order);

        System.out.println("Generated Order ID = " + orderId);


        // Save Order Items
        Order_ItemDAOImpl orderItemDAO = new Order_ItemDAOImpl();

        for (CartItem item : cart.getItems()) {

            Order_Item orderItem = new Order_Item();

            orderItem.setOrderId(orderId);
            orderItem.setMenuId(item.getMenuId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setItemPrice(item.getPrice());

            orderItemDAO.addOrder_Item(orderItem);
        }

        // Clear cart
        cart.clearCart();
        session.setAttribute("cart", cart);

        // Send Order ID to JSP
        request.setAttribute("orderId", orderId);

        request.getRequestDispatcher("ordersuccess.jsp")
               .forward(request, response);
    }
}