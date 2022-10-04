<%-- 
    Document   : page2
    Created on : Jun 7, 2022, 4:26:58 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          String kq1=request.getParameter("data");
          String kq2=request.getParameter("data2");
          kq1=kq1.toUpperCase() + " " +kq2 +" lan";
          response.sendRedirect("page1.jsp?result="+ kq1);
          //request.getRequestDispatcher("page1.jsp?result="+ kq1);
        %>
    </body>
</html>
