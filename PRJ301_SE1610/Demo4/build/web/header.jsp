<%-- 
    Document   : header
    Created on : Jun 2, 2022, 2:25:27 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <a href="#">Home</a> | <a href="#">register</a> | <a href="mainServlet?action=xemgiohang"> view cart </a>
    <form action="mainServlet" method="post">
        <input type="text" name="txtsearch"/>
        <input type="submit" value="search" name="action"/>
    </form>
</header>
