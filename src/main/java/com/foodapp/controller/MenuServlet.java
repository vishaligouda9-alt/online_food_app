package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.dao.impl.MenuDAOImpl;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * MenuServlet
 * Fetches all menu items of the selected restaurant.
 */

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {

	    int restaurantId =
	            Integer.parseInt(request.getParameter("restaurantId"));

	    MenuDAOImpl dao = new MenuDAOImpl();

	    List<Menu> menuList =
	            dao.getMenuByRestaurantId(restaurantId);

	    System.out.println(menuList);

	    request.setAttribute("menuList", menuList);

	    request.getRequestDispatcher("menu.jsp")
	           .forward(request, response);
	}
    }
