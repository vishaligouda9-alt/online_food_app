<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.Restaurant" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<style>

body{
    font-family: Arial, sans-serif;
    background:#f5f5f5;
    margin:0;
    padding:20px;
}

.container{
    width:90%;
    margin:auto;
}

.card{
    width:260px;
    background:#fff;
    padding:15px;
    margin:15px;
    border-radius:10px;
    box-shadow:0 0 10px rgba(0,0,0,0.2);
    display:inline-block;
    vertical-align:top;
    text-align:center;
}

.card img{
    width:100%;
    height:180px;
    border-radius:10px;
    object-fit:cover;
}

.card h3{
    margin-top:10px;
}

.card p{
    margin:5px 0;
}

.btn{
    display:inline-block;
    margin-top:10px;
    padding:10px 20px;
    background:#ff5722;
    color:white;
    text-decoration:none;
    border-radius:5px;
}

.btn:hover{
    background:#e64a19;
}

</style>

</head>

<body>

<div class="container">

<h2>Available Restaurants</h2>

<%
List<Restaurant> restaurantList =
    (List<Restaurant>) request.getAttribute("restaurantList");

if (restaurantList != null && !restaurantList.isEmpty()) {

    for (Restaurant restaurant : restaurantList) {
%>

<div class="card">

   
    <h3><%= restaurant.getRestaurantName() %></h3>

    <p><b>Cuisine:</b> <%= restaurant.getCuisineType() %></p>

    <p><b>Rating:</b> ⭐ <%= restaurant.getRating() %></p>

    <p><b>Phone:</b> <%= restaurant.getPhone() %></p>

    <p><b>Address:</b> <%= restaurant.getAddress() %></p>

    <a class="btn"
       href="menu?restaurantId=<%= restaurant.getRestaurantId() %>">
       View Menu
    </a>

</div>

<%
    }

} else {
%>

<h3>No Restaurants Available.</h3>

<%
}
%>

</div>

</body>
</html>