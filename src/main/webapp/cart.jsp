<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.foodapp.model.Cart"%>
<%@ page import="com.foodapp.model.CartItem"%>

<%
    Cart cart = (Cart) session.getAttribute("cart");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>My Cart</title>

<link rel="stylesheet" href="css/cart.css">

</head>

<body>

<div class="container">

<h1>My Shopping Cart</h1>

<%
if(cart == null || cart.getItems().isEmpty()){
%>

<h2>Your Cart is Empty!</h2>

<br>

<a class="shopBtn" href="restaurants">
    Continue Shopping
</a>

<%
}
else{
%>

<table border="1" cellpadding="10">

<tr>
    <th>Food Item</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Total</th>
    <th>Update</th>
    <th>Delete</th>
</tr>

<%
for(CartItem item : cart.getItems()){
%>

<tr>

<td><%= item.getItemName() %></td>

<td>₹ <%= item.getPrice() %></td>

<td>

<form action="updateCart" method="post">

<input
type="hidden"
name="menuId"
value="<%= item.getMenuId() %>">

<input
type="number"
name="quantity"
value="<%= item.getQuantity() %>"
min="1">

</td>

<td>

₹ <%= item.getTotalPrice() %>

</td>

<td>

<input
type="submit"
value="Update">

</form>

</td>

<td>

<a
href="deleteCart?menuId=<%= item.getMenuId() %>">

Delete

</a>

</td>

</tr>

<%
}
%>

</table>

<br>

<h2>

Grand Total : ₹ <%= cart.getTotalAmount() %>

</h2>

<br>

<a class="shopBtn" href="restaurants">

Continue Shopping

</a>

&nbsp;&nbsp;

<a class="checkoutBtn" href="checkout.jsp">

Proceed To Checkout

</a>

<%
}
%>

</div>

</body>

</html>