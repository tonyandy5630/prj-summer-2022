<%-- 
    Document   : page5
    Created on : Jun 21, 2022, 2:17:00 PM
    Author     : thanhtra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="num1" value="1000" />
        <c:set var="num2" value="500" />
        <h1>num1: <c:out value="anh yeu em"/></h1>
        <h1>num1: ${num1}</h1>
        <h1>num2: ${num2}</h1>
        <c:set var="obj" value="han va yeu" scope="session"/>
        <h1>Before: ${obj}</h1>
        <c:remove var="obj" scope="session"/>
        <h1>After: ${obj}</h1>
        <hr>
        <c:if test="${num1<num2}">
            <c:out  value="anh yeu em"/>
        </c:if>
    </body>
</html>
