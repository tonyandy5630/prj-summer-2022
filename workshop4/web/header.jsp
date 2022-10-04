<%-- 
    Document   : header
    Created on : Jun 2, 2022, 3:10:08 PM
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
        <header>
            <nav>
                <ul>
                    <li> <a href=""></a><img src="images/logo.jpg"></li>
                    <li> <a href="">Home</a></li>
                    <li> <a href="">Register</a></li>
                    <li> <a href="">Login</a></li>
                    <li> <form action="mainController">
                            <input type="text" name="txtsearch" value=" <%= request.getParameter("txtsearch") == null ? "": request.getParameter("txtsearch") %>">
                            <select name="searchby">
                                <option value="byname"> by name</option>
                                <option value="bycate"> by category</option>
                            </select>
                            <input type="submit" value="search" name="action">
                        </form></li>
                </ul>
            </nav>
        </header>
</body>
</html>
