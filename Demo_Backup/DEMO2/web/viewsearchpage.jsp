<%-- Document : viewsearchpage Created on : May 31, 2022, 1:49:34 PM Author :
thanh --%> <%@page import="basicobject.Plant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet"  href="style.css"/>
    </head>
    <body>
        <%@include  file="header.jsp" %>
        <%
            ArrayList<Plant> list = (ArrayList) request.getAttribute("result");
            if (list == null || list.isEmpty()) {
                out.println("Not found");
            } else {
        %>
        <table>
            <% for (Plant p : list) {
            %>
            <tr>
                <td><%= p.getId()%></td>
                <td><%= p.getName()%></td>
                <td><%= p.getPrice()%></td>
                <td><img src="<%= p.getImgpath()%>" width="100" height="100" /></td>
                <td><a href="#">Add to cart</a></td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>
