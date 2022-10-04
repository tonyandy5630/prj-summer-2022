<%-- 
    Document   : managePlant
    Created on : Jul 19, 2022, 10:53:51 AM
    Author     : ACER
--%>

<%@page import="sample.dao.PlantDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.dao.AccountDao"%>
<%@page import="sample.dto.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
        <link href="https://fonts.googleapis.com/css2?family=Inconsolata:wght@500&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a5f6897527.js" crossorigin="anonymous"></script>
        <script scr="scripts/scripts.js"/>
        <title>JSP Page</title>
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
            <div class="box Splant">
                <form action="mainController">
                    <input type="text" name="txtsearch" value="">
                    <input type="submit" value="searchCate" name="action">
                </form>
            </div>
        </div>
        <div class="table-container">
            <p id="warning">${requestScope.WARNING}</p>
            <div class="addPlantBtn-container">
                <div class="addPlantBtn">
                    <a href="mainController?action=redirectAddPlant">Add Category </a>
                </div>
            </div>
            <table class="plant table">
                <form>
                    <tr>
                        <th> ID </th>
                        <th> Category's name </th>
                        <th> Action </th>
                    </tr>
                    <c:forEach var="cat" items="${requestScope.cateList}" >
                    <form action="mainController" method="post">
                        <tr>
                            <td>
                                <c:out value="${cat.getId() }"></c:out>
                                </td>
                                <td>
                                <c:out value="${cat.getCateName()}" ></c:out>
                                </td>
                                <td  style="width:20%">
                                    <input type="hidden" value="${plant.getId() }" name="pid">
                                    <input class="action-btn delete" type="submit" onclick="return confirm(`Delete this category?`)" value="deleteCate" name="action"> |
                                    <input class="action-btn update" type="submit" onclick="return confirm(`Update this category ?`)" value="updateCat" name="action">
                            </td>
                        </tr>
                    </form> 
                    </c:forEach>
                </form>
            </table>
        </div>
        <c:import url="footer.jsp" />
        <%}%>
    </body>
</html>
