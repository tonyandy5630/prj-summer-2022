<%-- 
    Document   : viewCart
    Created on : Jun 15, 2022, 4:29:07 PM
    Author     : ACER
--%>

<%@page import="sample.dto.Plant"%>
<%@page import="sample.dao.PlantDao"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css">
        <script src="scripts.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
         <header>
            <%@include file="header.jsp" %>
        </header>
        <%
            String name = (String) session.getAttribute("name");
            if(name != null)
            {
        %>
        <h3>Welcome <%= session.getAttribute("name") %> back </h3>
        <h3> <a href="mainController?action=logout">Logout</a></h3>
        <h3> <a href="personalPage.jsp">Personal page</a></h3>
        <%
            }
        %>
        <p style="color:red;">
        <%= (request.getAttribute("WARNING"))==null?"":(String)request.getAttribute("WARNING") %>
        <a href="index.jsp">Login</a>
        </p>
        <section>
            <table class="shopping">
                <tr>
                    <td>
                        Product id 
                    </td>
                    <td>
                        Image
                    </td>
                    <td>
                        quantity
                    </td>
                    <td>Price</td>
                    <td>
                        action
                    </td>
                </tr>
                <%
                HashMap<String,Integer> cart = (HashMap) session.getAttribute("cart");
                int totalMoney = 0;
                if(cart != null)
                {
                    Set<String> pids = cart.keySet();
                    for(String pid : pids)
                    {
                        int quantity = cart.get(pid);
                        Plant plant = PlantDao.getPlant(Integer.parseInt(pid));
                %>
                    <form action="mainController" method="post">
                        <tr>
                            <td>
                                <input type="hidden" value="<%= pid %>" name="pid">
                                <a href="getPlantServlet?pid=<%= pid%>"><%= pid%></a>
                            </td>
                             <td><img src="<%= plant.getImgpath() %>" style="width:10vw;"></td>
                             <td><input type="number" name="quantity" value="<%= quantity %>"> </td>
                             <td><%= plant.getPrice() %> </td>
                            <td>
                                <input type="submit" value="update" name="action">
                                <input type="submit" onclick="return warning()"value="delete" name="action">
                            </td>
                        </tr>
                    </form>
                <%
                    totalMoney += quantity * plant.getPrice();
                    }
                }
                else
                {
                %>
                <tr>
                    <td>
                        Your cart is empty
                    </td>
                </tr>
                <%
                }
                %>
                <tr>
                    <td>
                        Total money: <%= totalMoney %>
                    </td>
                </tr>
            </table>
        </section>
    <setion>
        <form action="mainController" method="post">
            <input type="submit" value="saveOrder" name="action" class="submitorder">
        </form>
    </setion>           
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
