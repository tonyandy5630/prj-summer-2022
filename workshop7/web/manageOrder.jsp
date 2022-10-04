<%-- 
    Document   : manageOrder
    Created on : Jul 14, 2022, 9:01:25 PM
    Author     : ACER
--%>

<%@page import="sample.dao.AccountDao"%>
<%@page import="sample.dto.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
        <link href="https://fonts.googleapis.com/css2?family=Inconsolata:wght@500&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a5f6897527.js" crossorigin="anonymous"></script>
        <script src="scripts/manageOrderScripts.js" defer></script>
    </head>
    <body>
        <%
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            Cookie[] cookies = request.getCookies();
            Account acc = null;
            boolean login = false;
            if (name == null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("selector")) {
                        String token = c.getValue();
                        acc = AccountDao.getAccountByToken(token);
                        if (acc != null) {
                            name = acc.getFullname();
                            email = acc.getEmail();
                            login = true;
                        }
                    }
                }
            } else {
                login = true;
            }

            if (!login) {
        %>
        <p> <font color="red"> you must login as admin to view this page </font></p>
        <a href="index.jsp">Log in</a>
        <%
        } else {
        %>
        <c:import url="header_loginedAdmin.jsp" />
        <div class="full-width-container searchAcc">
            <div class="box date">
                <form action="mainController" method="post" class="form__search-order">
                    <label>Search by</label>
                    <select name="searchOrderBy">
                        <option value="OrdDate" selected>Order Date</option>
                        <option value="shipdate">Ship Date</option>
                    </select>
                    <label>From</label>
                    <input type="date" name="from" value="${requestScope.from}"> 
                    <label>To </label>
                    <input type="date" name="to" value="${requestScope.to}">
                    <input type="submit" value="searchOrder" name="action">
                    <p style="color:red;"> ${requestScope.WARNING}</p>
                </form>
            </div>
        </div>
                
        <table class="account table">
            <tr>
                <th> ID </th>
                <th> AccID </th>
                <th> Order Date</th>
                <th> Ship Date </th>
                <th> Status</th>
            </tr>
            <c:forEach var="ord" items="${requestScope.orderList}" >
                <tr>
                    <td>
                        <c:out value="${ord.getOrderID() }"></c:out>
                        </td>
                        <td>
                        <c:out value="${ord.getAccID()}" ></c:out>
                        </td>
                        <td>
                        <c:out value="${ord.getOrderDate()}" ></c:out>
                        </td>
                        <td>
                        <c:out value="${ord.getShipDate()}" ></c:out>
                        </td>
                        <td id="status">
                        <c:choose>
                            <c:when test="${ord.getStatus() eq 1}" > <c:out value="processing"/></c:when>
                            <c:when test="${ord.getStatus() eq 2}" > <c:out value="completed"/></c:when>
                            <c:when test="${ord.getStatus() eq 3}" > <c:out value="canceled"/></c:when>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:import url="footer.jsp" />
        <%}%>
    </body>
</html>
