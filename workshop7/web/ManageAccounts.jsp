<%-- 
    Document   : ManageAccounts
    Created on : Jul 11, 2022, 4:39:43 PM
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
        <link rel="stylesheet" href="css/styles.css" type="text/css" />
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
        <%--<%@include file="header_loginedAdmin.jsp" %>--%>
        <div class="full-width-container searchAcc">
            <div class="search box">
                <form action="mainController" method="post" class="form__search-acc">
                    <div class="input-container"> 
                        <input type="text" name="txtSearch" class="input-bar" placeholder="Ex : abc@domain.com">
                    </div>
                    <div class="submit-btn">
                        <input type="submit" value="searchAccount" name="action" class="button">
                    </div>
                </form>
            </div>
        </div>


        <table class="account table">
            <tr>
                <th> ID </th>
                <th> Email </th>
                <th> Full name</th>
                <th> Status</th>
                <th> Phone</th>
                <th> Role</th>
                <th> Action</th>
            </tr>
            <c:forEach var="acc" items="${requestScope.accountList}" >
                <tr>
                    <td>
                        <c:out value="${acc.getAccid()}"></c:out>
                        </td>
                        <td>
                        <c:out value="${acc.getEmail()}" ></c:out>
                        </td>
                        <td>
                        <c:out value="${acc.getFullname()}" ></c:out>
                        </td>
                        <td>
                        <c:choose>
                            <c:when test="${acc.getStatus() eq 1}">active</c:when>
                            <c:otherwise>inActive</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:out value="${acc.getPhone()}" ></c:out>
                        </td>
                        <td>
                        <c:choose>
                            <c:when test="${acc.getRole() eq 1}" >admin</c:when>
                            <c:otherwise>user</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:if test="${acc.getRole() eq 0}">
                            <c:url var="mylink" value="mainController">
                                <c:param name="email"  value="${acc.getEmail()}"></c:param>
                                <c:param name="status" value="${acc.getStatus()}"></c:param>
                                <c:param name="action" value="updateStatusAccount"></c:param>
                            </c:url>
                            
                            <a class="blockLink" href="${mylink}">
                                <c:choose>
                                    <c:when test="${acc.getStatus() eq 1}" >
                                        <c:out value="Block"></c:out>
                                    </c:when>
                                    <c:otherwise><c:out value="UnBlock"></c:out></c:otherwise>
                                </c:choose>
                            </a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <%}%>
        <c:import url="footer.jsp" />
    </body>
</html>
