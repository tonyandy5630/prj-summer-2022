<%-- 
    Document   : register
    Created on : Jun 23, 2022, 3:26:40 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="<c:url value="/images/download.png"/>"/>
        <link href="<c:url value="/css/styleRegister.css"/>" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <body>
          <form action="<c:url value="/user/checkRegister.do"/>">
              <h1 style="margin-bottom: 47px">Register Form</h1>
            <div class="inputbox ">
                <label for="account" >Account:</label>
                <input type="text" name="account" id="account" value="${account}"> 
            </div>
            <div class="inputbox">
                <label for="password" >Password:</label>
                <input  type="password" name="password"  value="${password}">
                <br/>
            </div>
                <div class="inputbox">
                <label for="checkPassword" >Check Password:</label>
                <input  type="password" name="checkPassword" id="pass" value="${checkPassword}">
                <br/>
            </div>
                <div style="color: red"> ${message}</div> <br/>
            <input type="submit" value="Login">
        </form>
                
    </body>
</html>
