<%-- 
    Document   : index
    Created on : Jun 14, 2022, 4:38:05 PM
    Author     : ACER
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
        <header>
            <a href="viewcart.jsp">view cart</a>
            <a></a>
            <a></a>
            <a></a>
        </header>
        <% 
            ArrayList<Plant> list = (ArrayList<Plant>) request.getAttribute("listPlants");
            if(list != null && list.size() > 0)
            {
                for(Plant p : list )
                {
        %>
        <table>
            <tr>
                <td rowspan="2">
                    <img src=" <%= p.getImgPath() %>" alt="" style="width:10%;">
                </td>
            </tr>
            <tr>
                <td>
                    <% p.getId(); %>
                </td>
            </tr>
            <tr>
                <td>
                    <% p.getName(); %>
                    
                </td>
            </tr>
            <tr>
                <td>
                    <% p.getPrice(); %>
                </td>
            </tr>
            <tr>
                <td> 
                    <a href="addToCartServlet?id=<%= p.getId() %>"> add to cart </a>
                </td>
            </tr>
        </table>
        <%  
                }
            }
            else
            {
                out.println("<p> coming soon </p>");
            }
        %>
        <%
            String msg = request.getParameter("warning");
            if(msg != null)
            {
        %>
        <script>
            alert("da them vao gio");
        </script>
        <%
            }
        %>
    </body>
</html>
