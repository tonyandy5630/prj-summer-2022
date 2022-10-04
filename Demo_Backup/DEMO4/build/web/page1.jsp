<%-- 
    Document   : page1
    Created on : May 31, 2022, 12:51:30 PM
    Author     : thanh
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="page2.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%!
            String name = "hello";

            public String test() {
                return name.toUpperCase();
            }
        %>
        <%
            Date d = new Date();
            out.println("hom nay: " + d.toString());
        %>
        <%
            String s = request.getParameter("txt");
            out.println("s= " + s);
        %>
        <%
            application.setAttribute("count", "100");
            out.println("Count: " + application.getAttribute("count"));
        %>
        <%
            String s1 = (String) pageContext.getAttribute("count", PageContext.APPLICATION_SCOPE);
            out.println("Count: " + s1);
        %>
        <h2><%=s%></h2> 
        <h2><%=test()%></h2> 
        <%
            int x = Integer.parseInt("emsad");
        %>
    </body>
</html>
