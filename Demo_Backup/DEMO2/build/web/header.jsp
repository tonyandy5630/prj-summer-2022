<%-- 
    Document   : header
    Created on : May 31, 2022, 1:37:28 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <a href="#">Home </a> | <a href="#">Login</a>
    <form action="SearchServlet" method="post">
        <input type="txt" name="txtsearch" />
        <input type="submit" value="search" />
    </form>
    <span> <%= request.getAttribute("warning") != null ? request.getAttribute("warning") : ""%></span>
</header>