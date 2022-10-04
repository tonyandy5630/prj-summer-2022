<%-- 
    Document   : Login
    Created on : Jun 18, 2022, 9:14:51 PM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/styleLogin.css"/>" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Lipstick shop</title>
    </head>
    <body>
        <form action="<c:url value="/user/checkLogin.do"/>">
            <h1 style="margin-top: 60px">Login Form</h1>
            <div class="inputbox ">
                <label for="account" >Account</label>
                <input type="text" name="account" id="account" value="${account}"> 
            </div>
            <div class="inputbox">
                <label for="pass" >Password</label>
                <input  type="text" name="password" id="pass" value="${password}">
                <br/>
            </div>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
