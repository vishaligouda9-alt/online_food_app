<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.Menu"%>

<%
List<Menu> menuList =
(List<Menu>)request.getAttribute("menuList");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Restaurant Menu</title>

<link rel="stylesheet" href="css/menu.css">

</head>

<body>

<h1>Restaurant Menu</h1>

<div class="container">

<%
for(Menu menu : menuList){
	
	if(menuList != null && !menuList.isEmpty()){

	%>

	<div class="card">

	<h2><%=menu.getItemName()%></h2>

	<p><%=menu.getDescription()%></p>

	<p>₹ <%=menu.getPrice()%></p>

	<form action="addToCart" method="post">

	<input type="hidden"
	name="menuId"
	value="<%=menu.getMenuId()%>">

	<input type="hidden"
	name="itemName"
	value="<%=menu.getItemName()%>">

	<input type="hidden"
	name="price"
	value="<%=menu.getPrice()%>">

	<label>Quantity</label>

	<input type="number"
	name="quantity"
	value="1"
	min="1">

	<br><br>

	<input type="submit"
	value="Add To Cart">

	</form>

	</div>

	<%
	    }else{
	%>

	<h2>No Menu Available</h2>

	<%
	}
	%>

</form>



</div>

<%
}
%>

</div>

</body>

</html>