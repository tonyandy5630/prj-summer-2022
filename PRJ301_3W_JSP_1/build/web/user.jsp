<%-- 
    Document   : user
    Created on : Aug 10, 2022, 9:25:59 AM
    Author     : phant
--%>

<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/User.css">
        <title>User Page</title>
    </head>
    <body>
        <h1>Welcome to Min's Store</h1>
        <%
            UserDTO loginUser= (UserDTO) session.getAttribute("LOGIN_USER");
            if(loginUser==null || !loginUser.getRoleID().equals("US")){
                loginUser = new UserDTO();
                response.sendRedirect("login.jsp");
            }
        %>
        Hello: <h2><%= loginUser.getFullName()%></h2>
        User ID: <%= loginUser.getUserID() %> </br
        Full Name: <%= loginUser.getFullName() %> </br>
        Role ID: <%= loginUser.getRoleID() %> </br>
        Password: <%= loginUser.getPassword() %> </br>
        Status: <%= loginUser.isStatus() %></br>
        <a href="MainController?action=Logout">Logout</a></br>
        <a href="shopping.jsp">Shopping page</a>
    </body>
</html>
