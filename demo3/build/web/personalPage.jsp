<%-- 
    Document   : personalPage
    Created on : Jun 9, 2022, 3:16:58 PM
    Author     : ACER
--%>

<%@page import="basisobject.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Account acc = (Account)session.getAttribute("loginedUser");
    if(acc == null)
    {
        response.sendRedirect("loginpage.jsp");
    }
    else
    {
%>
        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>JSP Page</title>
            </head>
            <body>
                <h2>Welcome <%= acc.getFullname() %></h2>
            </body>
        </html>
<%   } %>
