<%-- 
    Document   : page1
    Created on : May 31, 2022, 4:11:01 PM
    Author     : user
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            //declaration: khai bao them fields/methods trong clas page1_jsp.java
            String name="HELLO FPT";
            public String getName(){
               return name.toLowerCase();
            }
        %>
        <!-- khu vuc code html -->
        <h1>Hello World!</h1>
        <h2>em yeu co</h2>
        <%
          //scriplet  
          //khu vuc code java
          String tmp="yeu";
          Date d=new Date();
          out.println(d.toString());
          //lay value nhap tu trang index.html
          String s=request.getParameter("txt");
          out.println("<br>s="+s);
          application.setAttribute("count",100);
          out.println("<br/>count="+ application.getAttribute("count"));
          out.println("<br/>count=" + pageContext.getAttribute("count",PageContext.APPLICATION_SCOPE));
        %>
        <p><%= d.toString() %></p> 
        <p><%= getName()  %></p>
        <!-- expression -->
    </body>
</html>
