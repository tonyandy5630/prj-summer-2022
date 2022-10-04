<%-- 
    Document   : index
    Created on : Jun 2, 2022, 3:15:29 PM
    Author     : ACER
--%>

<%@page import="sample.dao.PlantDao"%>
<%@page import="sample.dto.Plant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <section>
            <form action="mainController" method="post" class="formlogin">
                <table>
                    <tr>
                        <td> email</td>
                        <td> <input type="text" name="email"></td>
                    </tr>
                    <tr>
                        <td>
                            Password
                        </td>
                        <td> <input type="text" name="password"></td>
                    </tr>
                    <tr> 
                        <td colspan="2">
                            <label> save login </label>
                            <input type="checkbox" value="savelogin" name="savelogin">
                        </td>
                    </tr>
                    <tr> <td colspan="2"><input type="submit" value="login" name="action"> </td></tr>
                </table>
            </form>
        </section>
        <%
            String keyword = request.getParameter("txtsearch");
            String searchby = request.getParameter("searchby");
            ArrayList<Plant> list;
            String[] tmp = {"out of stock", "available"};
            
            if(keyword == null && searchby == null)
            {
                list = PlantDao.getPlants("", "");
            }
            else
            {
                list = PlantDao.getPlants(keyword, searchby);
            }
            
            if( list != null && !list.isEmpty())
            {
                for(Plant p : list )
                { %>
                <table class="order">
                    <tr>
                        <td> 
                            <img alt="" src="<%= p.getImgpath() %>" class="plantimg">
                        </td>
                        <td> Product ID: <%= p.getId() %> </td>
                        <td> Product name ; <%= p.getName() %></td>
                        <td> Price: <%= p.getPrice() %></td>
                        <td> Status : <%= tmp[p.getStatus()] %> </td>
                        <td> <a href="mainController?action=addtocart&pid=<%= p.getId() %>"> Add to cart </a></td>
                    </tr>
                </table>
        <%      }%>
        <%  }%>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
