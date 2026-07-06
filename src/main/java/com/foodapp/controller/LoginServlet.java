package com.foodapp.controller;

import java.io.IOException;

import com.foodapp.dao.impl.UserDAOImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
 * LoginServlet
 *
 * This servlet verifies the user's login credentials.
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/*
	 * Handles POST request from login.jsp
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read login form values

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Create DAO object

		UserDAOImpl dao = new UserDAOImpl();

		// Get user from database using email

		User user = dao.getUserByEmail(email);

		// Check whether user exists

		if (user != null) {

			// Compare password

			if (user.getPassword().equals(password)) {

				// Create session

				HttpSession session = request.getSession();

				// Store logged-in user in session

				session.setAttribute("loggedInUser", user);

				// Redirect to home page

				response.sendRedirect(request.getContextPath() + "/restaurants");

			} else {

				// Password incorrect

				response.getWriter().println("<h2>Invalid Password!</h2>");

			}

		} else {

			// Email not found

			response.getWriter().println("<h2>User Not Found!</h2>");

		}

	}

}