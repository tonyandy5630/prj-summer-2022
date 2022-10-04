<%-- 
    Document   : login
    Created on : Aug 10, 2022, 9:21:05 AM
    Author     : phant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/loginPage.css">
        <title>Login Page</title>
    </head>
    <body>
        <header>
            <h1>Welcome to Min's Store</h1>
        </header>
        <img id ="shop.png" src ="image/shop.png">
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID" required=""/></br>
            Password <input type="password" name="password" required=""/></br>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        <%
            String error = (String)request.getAttribute("ERROR");
            if(error==null){
                error ="";
            }
        %>
        <%= error %>
        <a href="createUser.jsp">Create new user</a>
        <footer>
            <%@include file="footer.jsp"%>
        </footer>
    </body>
</html>
