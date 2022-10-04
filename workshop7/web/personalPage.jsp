<%-- 
    Document   : personalPage
    Created on : Jun 2, 2022, 3:35:50 PM
    Author     : ACER
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="sample.dto.Account"%>
<%@page import="sample.dao.AccountDao"%>
<%@page import="sample.dto.Order"%>
<%@page import="sample.dao.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            Cookie[] c = request.getCookies();
            boolean login = false;
            Account acc = null;
            if (name == null) {
                for( Cookie aCookie : c)
                {
                    if(aCookie.getName().equals("selector"))
                    {
                        String token = aCookie.getValue();
                        acc = AccountDao.getAccountByToken(token);
                        if(acc != null)
                        {
                            name = acc.getFullname();
                            email = acc.getEmail();
                            login = true;
                        }
                    }
                }
            }
            else 
            {
                login = true;
            }
            if(!login)
            {
        %>
        <p> <font color="red"> you must login to view personal page </font></p>
        <a href="index.jsp">Log in</a>
        <%  } 
            else 
            { 
            ArrayList<Order> list = new ArrayList<>();
            if( request.getAttribute("orders") != null )
            {
                list = (ArrayList<Order>) request.getAttribute("orders");
            }
            else
            {
                list =  OrderDAO.getOrders(email);
            }
        %>
        <header> 
            <%@include file="header_loginedUser.jsp" %>
        </header>
        <section class="personal">
            <h3> Welcome <%= name %> back </h3>
        </section>
             <a href="mainController?action=logout"> logout </a>
        <section> 
            <%
                String uri = request.getRequestURI();
                String pageName = uri.substring(uri.lastIndexOf("/")+1);
                if(acc != null)
                {
                    email = acc.getEmail();
                }
                else
                {
                    email = (String) session.getAttribute("email");
                }
                String condition = "undifined";
                String[] status = {"", "processing", "completed", "canceled"};
                if (list != null && !list.isEmpty()) {
                    for (Order ord : list) {
            %>
            <table class="order">
                <tr>
                    <td> Order ID</td>
                    <td>Order Date </td>
                    <td>Ship Date</td>
                    <td> Order's status</td>
                    <td> action </td>
                </tr>
                <tr>
                    <td><%= ord.getOrderID()%></td>
                    <td><%=  ord.getOrderDate()%></td>
                    <td><%= ord.getShipDate() %></td>
                    
                    <td>
                    <%  if(request.getParameter("condition") == null || (request.getParameter("condition") != null && Integer.parseInt(request.getParameter("orderid")) != ord.getOrderID()))
                        { %>
                           <%= status[ord.getStatus()]%>
                    <%  } 
                        else if( request.getParameter("condition") != null && Integer.parseInt(request.getParameter("orderid")) == ord.getOrderID()) 
                        { 
                            condition = request.getParameter("condition"); 
                            if( condition.equals("succeed"))
                            { %>
                                <%= "processing"%>
                    <%      } 
                            else if(condition.equals("failed"))
                            { %>
                                <%= condition%>
                    <%      }
                            else
                            { %>
                                <%= condition%>
                    <%      } %>
                    <%  } %>
                        <br> <% if (ord.getStatus() == 1) { %>
                        <a href="#"> cancel order</a>
                        <%  }
                        if(ord.getStatus() == 3)
                        { %>
                            <a href="<%=pageName%>?orderid=<%=ord.getOrderID()%>">Reorder</a>
                    <%  }
                        if( request.getParameter("condition") == null )
                        {
                            if(request.getParameter("orderid") != null && Integer.parseInt(request.getParameter("orderid")) == ord.getOrderID())
                            {
                                int orderID = Integer.parseInt(request.getParameter("orderid")); %>
                                <form action="mainController">
                                    <input type="radio" value="true" name="confirm">
                                    <label for="yes"> Yes</label>
                                    <input type="radio" value="false" name="confirm">
                                    <label for="no"> No</label>
                                    <input type="hidden" value="<%=orderID%>" name="orderID">
                                    <input type="hidden" value="<%=pageName%>" name="page">
                                    <input type="submit" value="reorder" name="action">
                                </form>
                    <%  } 
                    } %>
                    </td>
                    <td>
                        <a href="OrderDetail.jsp?orderid=<%=ord.getOrderID()%>"> detail</a>
                    </td>
                </tr>
            </table>
            <%  } // end for loop   %>
            <%  }else{
                if(request.getAttribute("orders") != null){
             %>
            <p> You dont have any order from <%= (request.getAttribute("from")) == null ?"":request.getAttribute("from") %> to <%= (request.getAttribute("to")) == null ?"":request.getAttribute("to") %> </p>
            <%  } 
                else 
                {%>
            <p> You don't have any order</p>
            <%  }%>
            <%}%>
        </section>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        <%}%>
    </body>
</html>
