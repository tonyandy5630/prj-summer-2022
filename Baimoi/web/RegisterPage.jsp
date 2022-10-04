<%-- 
    Document   : RegisterPage
    Created on : May 31, 2022, 3:32:37 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <<%@include  file="header.jsp" %>
        <section>
            <form action="mainController" method="post">
                <p>email: <input type="text" name="txtemail"/></p>
                <p>password: <input type="password" name="txtpassword"/></p>
                <p>full name: <input type="text" name="txtfullname"/></p>
                <p>phone: <input type="text" name="txtphone"/></p>
                <p><input type="submit" name="action" value="register"></p>
            </form>
            <p><%= request.getAttribute("error") %></p>
        </section>
    </body>
</html>
