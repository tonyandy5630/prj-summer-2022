<%-- 
    Document   : header
    Created on : Jun 2, 2022, 2:26:48 PM
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
        <a href="#"> Home </a>
        <a href="#"> Register </a>
        <a href="mainServlet?action=xemgiohang"> view cart </a>
        <form action="mainServlet" method="post">
            <input type="text" name="keyword">
            <input type ="submit" value="search" name="action">
        </form>
    </body>
</html>
