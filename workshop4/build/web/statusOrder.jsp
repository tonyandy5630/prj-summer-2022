<%-- 
    Document   : completedOrder
    Created on : Jun 9, 2022, 3:58:52 PM
    Author     : ACER
--%>

<%@page import="sample.dao.OrderDAO"%>
<%@page import="sample.dto.Order"%>
<%@page import="sample.dto.Account"%>
<%@page import="sample.dao.AccountDao"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = (String) session.getAttribute("name");
            if(name == null)
            { %>
                <h1 style="color:red;"> Please log in to use this page</h1>
                <a href="index.jsp">Log in</a>        <%  }
            else
            {
                String uri = request.getRequestURI();
                String pageName = uri.substring(uri.lastIndexOf("/")+1);
                int accID = (int) session.getAttribute("accID");
                Account loggedAcc = AccountDao.getAccountByID(accID);
                String condition = "undifined";
                String[] statusStrings = {"", "processing", "completed", "canceled"};
                int status = Integer.parseInt(request.getParameter("status"));
                ArrayList<Order> ordList = OrderDAO.getOrderByStatus(loggedAcc.getAccid(), status);
            %>
        <header>
            <%@include file="header_loginedUser.jsp" %>
        </header>
        <h1> <%= name %> 's <%=statusStrings[status]%> Order(s)</h1>
        <section>
            <%  if(ordList != null && !ordList.isEmpty())
                {%>
                    <% for(Order ord : ordList)
                        { %>
                            <table class="order">
                            <tr>
                                <td>Order ID</td>
                                <td>Order date</td>
                                <td>Ship Date</td>
                                <td>Status</td>
                            </tr>
                            <tr>
                                <td> <%= ord.getOrderID() %></td>
                                <td> <%= ord.getOrderDate() %></td>
                                <td> <%= ord.getShipDate() %></td>
                                <td>
                                <%  if(request.getParameter("orderid") == null )
                                    { %>
                                       <%= statusStrings[ord.getStatus()]%>
                                <%  } 
                                    else if(request.getParameter("orderid") != null) 
                                    { 
                                        if(request.getParameter("condition") != null)
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
                                <%      }
                                        else 
                                        { %>
                                            <%= statusStrings[ord.getStatus()]%>
                                <%      } %>
                                <%  }%>
                                </td>
                                <td>
                                    <a href="OrderDetail.jsp?orderid=<%=ord.getOrderID()%>"> 
                                        Detail
                                    </a>
                                    <%  if(status==3)
                                        { %>
                                            <a href="<%=pageName%>?orderid=<%=ord.getOrderID()%>&status=3">Reorder</a>
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
                                                    <input type="hidden" value="<%=status%>" name="status">
                                                    <input type="hidden" value="<%=pageName%>" name="page">
                                                    <input type="submit" value="reorder" name="action">
                                                </form>
                                        <%  } 
                                            if( request.getParameter("condition") != null && Integer.parseInt(request.getParameter("orderid")) == ord.getOrderID() ) 
                                            { 
                                                condition = request.getParameter("condition"); 
                                                if( condition.equals("succeed"))
                                                { %>
                                                <p style="color:orange">Ordered succeed</p>
                                        <%      } 
                                                else if(condition.equals("failed"))
                                                { %>
                                                    <p style="color:red">Ordered failed</p>
                                        <%      }
                                                else
                                                { %>

                                                    <p style="color:gray">Order canceled</p>
                                        <%      } %>
                                        <%  }%>
                                    <%  }%>
                                </td>
                            </tr>
            <%          }    %>
                            </table>
            <%  }   
                else
                { %>
                    <h3> You don't have any <%= statusStrings[status] %> order(s)</h3>
            <%  }   %> 
        </section>
        <%  }       %>
         <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
