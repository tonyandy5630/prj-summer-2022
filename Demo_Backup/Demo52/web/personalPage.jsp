<%-- 
    Document   : personalPage
    Created on : Jun 16, 2022, 1:24:41 PM
    Author     : thanhtra
--%>

<%@page import="basicobject.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>welcome, <%= ( (Account) session.getAttribute("user")).getFullname()%></h2>
        <a href="viewcart.jsp">view cart</a>    </body>
</html>
