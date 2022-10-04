<%-- 
    Document   : page1
    Created on : May 31, 2022, 4:11:04 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%!
            String name="Hello fpt";
            public String getName(){
                return name.toLowerCase();
            }
        %>
        <%
            String s = request.getParameter("name");
            out.println("<br> s= " + s);
            application.setAttribute("count",100);
            out.println("</br> count=" + application.getAttribute("count"));
//            out.println("<br/> txt=" + pageContext.getAttribute("count",PageContext.APPLICATION_CONTEXT));
            
        %>
        <p> <%=s %></p>
        <p> my name  =<%= getName() %></p>
    </body>
</html>
