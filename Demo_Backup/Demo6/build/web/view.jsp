<%-- 
    Document   : view
    Created on : Jun 21, 2022, 2:51:45 PM
    Author     : thanhtra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="t"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <t:set var="total" value="0"/>
        <t:set var="list" value="${ requestScope.result }"/>
        <t:if test="${not empty list}">
            <t:forEach items="${list}" var="b">  
                <table>
                    <tr>
                        <td>${b.id}</td>
                        <td>${b.title}</td>
                        <td>${b.price}</td>
                        <td>
                            <t:url var="mypage" value="page${b.id}.jsp">
                                <t:param name="id" value="${b.id}"/>
                            </t:url>
                            <a href="${mypage}">
                                Detail  
                            </a>
                        </td>
                    </tr>
                </table>
                <t:set var="total" value="${total + b.price}"/>
            </t:forEach>
            <h1>Total money: ${total}</h1>
        </t:if>
    </body>
</html>
