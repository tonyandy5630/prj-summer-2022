<%-- 
    Document   : personalpage
    Created on : Jun 9, 2022, 3:16:59 PM
    Author     : user
--%>

<%@page import="basicobject.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Account acc=(Account)session.getAttribute("loginedUser");
    if(acc==null){
        response.sendRedirect("index.html");
    }
    else{ 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Welcome, <%=  acc.getEmail() %></h2>
        <a href="viewcart.jsp"> view cart</a>
    </body>
</html>
<%}%>