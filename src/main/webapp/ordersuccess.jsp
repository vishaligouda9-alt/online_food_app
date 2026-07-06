<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    Integer orderId = (Integer) request.getAttribute("orderId");

    if (orderId == null) {
        orderId = 0;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmed</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family:Arial, sans-serif;
    background:linear-gradient(135deg,#fff3e0,#ffe0b2);
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.container{
    width:450px;
    background:#fff;
    padding:30px;
    border-radius:15px;
    text-align:center;
    box-shadow:0 8px 20px rgba(0,0,0,0.2);
}

.success-img{
    width:120px;
    height:120px;
    object-fit:contain;
    margin-bottom:15px;
}

.delivery-img{
    width:220px;
    height:150px;
    object-fit:contain;
    margin:20px 0;
}

h1{
    color:#28a745;
    margin-bottom:10px;
}

.message{
    color:#555;
    font-size:18px;
    margin-bottom:20px;
}

.order-box{
    background:#f5f5f5;
    border-radius:10px;
    padding:15px;
    margin:20px 0;
}

.order-box h2{
    color:#333;
    margin-bottom:10px;
}

.order-box h3{
    color:#ff5722;
    font-size:32px;
}

.status{
    color:#444;
    font-size:18px;
    margin-top:15px;
}

.btn{
    display:inline-block;
    margin-top:25px;
    background:#ff5722;
    color:white;
    text-decoration:none;
    padding:12px 30px;
    border-radius:25px;
    font-size:18px;
    transition:0.3s;
}

.btn:hover{
    background:#e64a19;
}

</style>

</head>

<body>

<div class="container">

    

    <h1>🎉 Order Placed Successfully!</h1>

    <p class="message">
        Thank you for ordering with us.
    </p>

    

    
    <p class="status">🍔 Your food is being prepared.</p>
    <p class="status">🚚 Estimated Delivery: 30–40 Minutes</p>

    <a href="restaurants" class="btn">Continue Shopping</a>

</div>

</body>
</html>