<%-- 
    Document   : error
    Created on : Jun 10, 2022, 2:12:07 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Order <%= request.getParameter("orderid") %> will not be reorder </h1>
        <a href="statusOrder.jsp?accID=<%=session.getAttribute("accID")%>&status=3">Reorder another one</a>
        <a href="personalPage.jsp"> Back to homepage</a>
    </body>
</html>
