<%-- 
    Document   : errorPage
    Created on : Jun 11, 2022, 11:32:03 PM
    Author     : ACER
--%>

<%@page import="sample.dto.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= request.getParameter("message") %></h1>
        <% 
            if(request.getAttribute("orders") != null )
            {
            ArrayList<Order> orders = (ArrayList) request.getAttribute("orders");
            for(Order order : orders){
                %>
                <h3> <%= order.getOrderID() %> + <%= order.getOrderDate() %> </h3>
                <%}
            }
            else{
            %>
            <h3> no order</h3>
            
            <%
            }
            %>
        <a href="personalPage.jsp"> Back to home page</a>
        <a href="index.jsp"> back to login </a>
    </body>
</html>
