<%-- 
    Document   : header_loginedUster
    Created on : Jun 2, 2022, 3:32:59 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <ul>
                <li> <a href="personalPage.jsp"> Home </a></li>
                <li> <a href="profilePage.jsp"> Change profile</a></li>
                <li> <a href="statusOrder.jsp?status=2"> Completed orders </a></li>
                <li> <a href="statusOrder.jsp?status=3"> Canceled orders</a></li>
                <li> <a href="statusOrder.jsp?&status=1"> Processing orders </a></li>
                <form action="mainController" method="post">
                    <li> from <input type="date" name="from" value="<%= (request.getAttribute("from")) == null ?"":request.getAttribute("from") %>"> 
                        to <input type="date" name="to" value="<%= (request.getAttribute("to")) == null ?"":request.getAttribute("to") %>">
                        <input type="hidden" value="<%= (int) session.getAttribute("accID")%>" name="accid">
                    <input type="submit" value="search" name="action">
                     <p style="color:red;"> <%= (request.getAttribute("WARNING"))==null?"":request.getAttribute("WARNING")%></p></li>
                    
                </form>
               
            </ul>
        </nav>
    </body>
</html>
