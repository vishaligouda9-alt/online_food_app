<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Checkout</title>
<link rel="stylesheet" href="css/checkout.css">
</head>

<body>

<h1>Checkout</h1>

<form action="checkout" method="post">

    <label>Delivery Address</label>
    <br><br>

    <textarea
        name="address"
        rows="4"
        cols="40"
        required></textarea>

    <br><br>

    <label>Payment Mode</label>
    <br><br>

    <select name="paymentMode">
        <option value="Cash On Delivery">Cash On Delivery</option>
        <option value="UPI">UPI</option>
        <option value="Card">Card</option>
    </select>

    <br><br>

    <input type="submit" value="Place Order">

</form>

</body>
</html>