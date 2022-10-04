<%-- 
    Document   : OrderDetail
    Created on : Jun 8, 2022, 11:08:00 PM
    Author     : ACER
--%>

<%@page import="sample.dao.OrderDAO"%>
<%@page import="sample.dto.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = (String) session.getAttribute("name");
            if (name == null) {
        %>
        <p> <font color="red"> you must login to view personal page </font></p>
            <%} else {%>
        <header> 
            <%@include file="header_loginedUser.jsp" %>
        </header>
        <section>
            <h3> Details </h3>
            <a href="mainController?action=logout"> logout </a>
        </section>

        <section>
            <% String orderid = request.getParameter("orderid");
                if (orderid != null) 
                {
                    int orderID = Integer.parseInt(orderid.trim());
                    ArrayList<OrderDetail> list = OrderDAO.getOrderDetail(orderID);
                    if (list != null && !list.isEmpty()) 
                    {
                        int money = 0;
                        for (OrderDetail detail : list) 
                        { %>
                            <table class="order detail">
                                <tr>
                                    <td>Order ID</td>
                                    <td>Plant ID</td>
                                    <td>Plant Name</td>
                                    <td>Image</td>
                                    <td>Quantity</td>
                                </tr>
                                <tr>
                                    <td> <%= detail.getOrderID()%></td>
                                    <td> <%= detail.getPlantID()%></td>
                                    <td> <%= detail.getPlantName()%></td>
                                    <td>  <img src="<%= detail.getImgPath()%>" alt="" class="plantimg"> <br> <%= detail.getPrice()%></td>
                                    <td> <%= detail.getQuantity()%></td>
                                    <% money += detail.getPrice() * detail.getQuantity(); %>
                                </tr>
                            </table>
            <%          }       %>
                        <h3> Total money: <%= money%></h3>
            <%      } 
                    else 
                    {           %>
                        <h3> You don't have any order </h3>
            <%      }       
                } 
                else 
                { %>
                    <h3> You don't have any order </h3>
            <%  }%>
        </section>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        <%}%>
    </body>
</html>
