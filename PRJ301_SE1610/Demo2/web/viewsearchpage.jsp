<%-- 
    Document   : viewsearchpage
    Created on : May 31, 2022, 5:04:10 PM
    Author     : user
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="basicobject.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          ArrayList<Account> list=(ArrayList)request.getAttribute("ketqua");
          if(list==null || list.size()==0){
              out.println("not found");
          }
          else{
        %>
        <table>
            <%
                for(Account acc:list){
            %>
            <tr>
                <td><%= acc.getEmail() %></td>
                <td><%= acc.getFullname() %></td>
                <td><%= acc.getPhone() %></td>
                <td><%= acc.getStatus() %></td>
                <td><a href="#">block/unblock</a></td>
            </tr>
            <% } %>
        </table>
        <%}%>
    </body>
</html>
