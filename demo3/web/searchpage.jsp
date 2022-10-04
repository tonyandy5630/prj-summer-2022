<%-- 
    Document   : searchpage
    Created on : May 31, 2022, 4:57:30 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="SearchServlet" method="post">
            <input type="text" name="txtsearch"/>
            <input type="submit" value="search"/>
        </form>
        <%
            String msg=(String)request.getAttribute("warning");
        %>
        <p><%=  (msg!=null)?msg:"" %></p>
    </body>
</html>
