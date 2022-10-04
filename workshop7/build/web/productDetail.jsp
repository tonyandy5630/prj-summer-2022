<%-- 
    Document   : productDetail
    Created on : Jun 20, 2022, 5:19:24 PM
    Author     : ACER
--%>

<%@page import="sample.dao.PlantDao"%>
<%@page import="sample.dto.Plant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(request.getParameter("pid") != null )
            {
                int pid = Integer.parseInt(request.getParameter("pid"));
                Plant plant = PlantDao.getPlant(pid);
        %>
        <table>
            <tr>
                <td> Image</td>
                <td>Detail </td>
            </tr>
            <tr>
                <td rowspan="5">
                    <img style="width:10vw" src="<%= plant.getImgpath() %>" alt="">
                </td>
                 <td>Product id : <%= pid %></td>
            </tr>
            <tr>
                <td> Price : <%= plant.getPrice() %></td>
            </tr>
            <tr>
                <td> Description: <%= plant.getDescription() %></td>
            </tr>
            <tr>
                <td> Status : <%= plant.getStatus() %></td>
            </tr>
            <tr>
                <td> category : others </td>
            </tr>
        </table>
        <%    }
            else
            {
            }
        %>
    </body>
</html>
