<%-- 
    Document   : showCart
    Created on : Jun 21, 2022, 8:50:40 PM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/styleShowCart.css"/>" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Lipstick shop</title>
    </head>
    <body>
        <div class="show">
            <div class="title">
                <h1>Mặt hàng đã chọn</h1> 
                <a href="<c:url value="/home/homePage.do"/>"><i class="fa-solid fa-plus"></i> Thêm mặt hàng</a>
            </div>
            <div class="productList">
                <div class="row">
                    <c:forEach items="${cart.list}" var="p">
                        <div class="col-md-10">
                            <p>${p.product.name} x${p.quantity}</p>
                            <p><fmt:formatNumber value="${p.product.price*p.quantity}" pattern="#,### VND" /></p>
                        </div>
                            <a href="<c:url value="/home/showCart.do?productID=${p.product.productid}"/>" class="col-md-2"><i class="fa-solid fa-trash"></i></a>
                        <br/>
                    </c:forEach>
                </div>
            </div>
                <a href="<c:url value="/home/checkout.do"/>" class="btn btn-default confirm "><i class="fa-solid fa-circle-check"></i> Xác nhận đơn Hàng</a>
        </div>
    </body>
</html>
