<%-- Document : header Created on : May 31, 2022, 3:20:49 PM Author : thanh --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <ul>
        <li>
            <a href="#">Home</a>
        </li>
        <li><a href="RegisterPage.jsp">Register</a></li>
        <li>
            <form action="mainController" method="post">
                <input type="text" name="txtsearch" />
                <input type="submit" name="action" value="search" />
            </form>
        </li>
    </ul>
</header>
