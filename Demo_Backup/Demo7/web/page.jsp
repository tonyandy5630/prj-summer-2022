<%-- 
    Document   : page
    Created on : Jun 23, 2022, 12:48:01 PM
    Author     : thanhtra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tlds/mytags.tld" prefix="t" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="id" begin="1" end="3" step="1">
            <t:Plant id="${id}"></t:Plant>
        </c:forEach>
    </body>
</html>
