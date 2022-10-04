<%-- 
    Document   : page1
    Created on : Jun 21, 2022, 1:02:01 PM
    Author     : thanhtra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="b"  class="basic.Book"  scope="request"> 
            <jsp:setProperty name="b" property="id" value="100"/>
            <jsp:setProperty name="b" property="title" value="han va yeu"/>
            <jsp:setProperty name="b" property="id" value="2000"/>
        </jsp:useBean>
        <jsp:forward page="page2.jsp" >
            <jsp:param name="count" value="1000"/>
        </jsp:forward>
    </body>
</html>
