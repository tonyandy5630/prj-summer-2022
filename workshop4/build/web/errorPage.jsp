<%-- 
    Document   : errorPage
    Created on : Jun 11, 2022, 11:32:03 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= request.getParameter("message") %></h1>
        <a href="personalPage.jsp"> Back to home page</a>
    </body>
</html>
