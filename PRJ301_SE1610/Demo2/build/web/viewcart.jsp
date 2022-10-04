<%-- 
    Document   : viewcart
    Created on : Jun 16, 2022, 2:23:31 PM
    Author     : ACER
--%>

<%@page import="java.sql.Date"%>
<%@page import="basicobject.Plant"%>
<%@page import="dbaccess.PlantDao"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function warning()
            {
                var a = window.confirm("Ban co muon bo sp nay ?");
                if(a === true)
                    return true;
                return false;
            }
        </script>
    </head>
    <body>
        <%
            HashMap<String,Integer> cart = (HashMap<String,Integer>) session.getAttribute("cart");
            if(cart == null )
            {
                out.println("<p> empty <p>");
            }
            else
            {
        %>
            <table>
                <caption> Thong tin gio hang </caption>
                <tr>
                    <th> id</th>
                    <th> name</th>
                    <th> img </th>
                    <th> price </th>
                    <th> quantity </th>
                </tr>
                <%
                    int total = 0;
                    for(String id : cart.keySet())
                    {
                        Plant p = PlantDao.getPlant(Integer.parseInt(id));
                %> 
                <tr>
                    <form action="mainController" method="post">
                        <input type="hidden" value="<%= p.getId() %>" name="txtid">
                        <th> <%= p.getId() %></th>
                        <th><%= p.getName() %>  </th>
                        <th> <img src="<%=  p.getImgPath()%>" style="width:10%"></th>
                        <th> <%= p.getPrice()  %>  </th>
                        <th> <input type="number" value="<%= cart.get(id) %>" min ="1" max="20" name="txtquantity"> </th>
                        <th>
                            <input type="submit" value="remove" onclick="return warning()" name="action">
                            <input type="submit" value="update" name="action">
                        </th>
                    </form>
                </tr>
                <% total += p.getPrice() * cart.get(id); %>
                <%  } %>
                <p> tong tien thanh toan: <%= total%>vnd</p>
                <p> Ngay dat hang : <%= new Date(System.currentTimeMillis())%> </p>
                <p> Ngay giao hang du kien : sau 7 ngay</p>
                <a href="mainController?action=saveorder">Hoan thanh don hang </a>
            </table>
        <%  }%>
    </body>
</html>
