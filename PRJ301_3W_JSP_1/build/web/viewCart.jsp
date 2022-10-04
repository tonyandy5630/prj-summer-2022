<%-- 
    Document   : viewCart
    Created on : Aug 15, 2022, 8:50:57 AM
    Author     : phant
--%>

<%@page import="tree.Cart"%>
<%@page import="tree.Tree"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/viewPage.css">
        <title>View Page</title>
    </head>
    <body>
        <h1>Your shopping cart</h1>
        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border='1'>
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Edit</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (Tree tree : cart.getCart().values()) {
                        total += tree.getQuantity() * tree.getPrice();
                %>          
                <tr>
            <form action="MainController">
                <td><%= count++%></td>
                <td>
                    <%= tree.getId()%>
                    <input type="hidden" name="id" value="<%= tree.getId()%>"/>
                </td>
                <td><%= tree.getName()%></td>
                <td><%= tree.getPrice()%>$</td>
                <td>
                    <input type="number" name="quantity" value="<%= tree.getQuantity()%>" min="1"/>
                </td>
                <td><%= tree.getQuantity() * tree.getPrice()%>$</td>
                <td>
                    <input type="submit" name="action" value="Edit"/>
                </td>
                <td>
                    <input type="submit" name="action" value="Remove"/>
                </td>
            </form>

        </tr>
        <%
            }
        %>
    </tbody>
</table>
<h1>Total: <%= total%>M $</h1>
<%
    }
%>
<a href="shopping.jsp">Add More</a>
</body>
</html>
