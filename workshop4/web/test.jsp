<%-- 
    Document   : test
    Created on : Jun 10, 2022, 11:08:48 PM
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
        <h1><% int accID = (int)session.getAttribute("accID");
               String name = (String) session.getAttribute("name"); %>
            <%= accID %> <%= name %>
        </h1>
    </body>
</html>
