<%-- 
    Document   : page1
    Created on : Jun 21, 2022, 4:28:10 PM
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
        <jsp:useBean id="b" class="basic.Book" scope="request" >
            <jsp:setProperty name="b" property="id" value="1" ></jsp:setProperty>
            <jsp:setProperty name="b" property="title" value="han va yeu" ></jsp:setProperty>
            <jsp:setProperty name="b" property="price" value="1" ></jsp:setProperty>
        </jsp:useBean>
        <jsp:forward page="page2.jsp">
            <jsp:param name="count" value="1" />
        </jsp:forward>
    </body>
</html>
