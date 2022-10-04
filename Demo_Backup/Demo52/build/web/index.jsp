<%-- 
    Document   : index
    Created on : Jun 14, 2022, 1:00:48 PM
    Author     : thanhtra
--%>

<%@page import="basicobject.Plant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4><a href="viewcart.jsp"> view cart</a>        </h4>
        
        <%
            ArrayList<Plant> list = (ArrayList) request.getAttribute("listPlants");
            if (list != null && list.size() > 0) {
                for (Plant p : list) {

        %>
        <table>
            <tr><td rowspan="4"><img src="<%= p.getImgpath()%>"/></td></tr>
            <tr><td><%= p.getId()%></td></tr>
            <tr><td><%= p.getName()%></td></tr>
            <tr><td><a href="mainController?action=addtocart&id=<%=p.getId()%>">add to cart</a></td></tr>
        </table>     
        <%                }
            } else
                out.println("comming soon");
        %>
        <%
            String msg = request.getParameter("warning");
            if (msg != null) {

        %>
        <script>
            alert("them thanh cong");
        </script>
        <%            }
        %>
    </body>
</html>
