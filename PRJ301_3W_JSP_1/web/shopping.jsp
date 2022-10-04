<%-- 
    Document   : shopping
    Created on : Aug 15, 2022, 7:46:57 AM
    Author     : phant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/shoppingPage.css">
        <title>Shopping Page</title>
    </head>
    <body>
        <h1>Welcome to Min's Store</h1>
        <a href="MainController?action=Logout">Logout</a>
        Choose your favorite plant:
        <form action="MainController">
            <select name="cmbTree">
                <option value="T01-Ben Tre Coconut-10">Ben Tre Coconut-10M</option>
                <option value="T02-Chau Phi Cactus-5">Chau Phi Cactus-5M</option>
                <option value="T03-Rock Lotus-3">Rock Lotus-3M</option>
                <option value="T04-Viet Nam SaNu-3">Viet Nam SaNu-3M</option>
                <option value="T05-Lemon-1">Lemon-1M</option>
            </select>
            <select name="cmbQuantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="10">10</option>
            </select>
            <input type="submit" name="action" value="Add"/>
            <input type="submit" name="action" value="View"/>
        </form>
        <%
        String message = (String) request.getAttribute("MESSAGE");
        if(message == null) message ="";
        %>
        <%= message %>
    </body>
</html>
