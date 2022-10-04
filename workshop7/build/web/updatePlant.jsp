<%-- 
    Document   : updatePlant
    Created on : Jul 21, 2022, 3:56:45 AM
    Author     : ACER
--%>

<%@page import="sample.dto.Plant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Plant p = (Plant) request.getAttribute("plant");
        %>
        <div class="add-container">
            <form action="mainController" method="post" class="form__addPlant">
                <label>Plant name : <%= p.getName() %> </label>
                <input class="form__pName" type="text" name = "pName" placeholder = "Enter new plant's name" >
                <label>Plant's price : <%= p.getPrice() %> </label>
                <input class="form__pPrice" type="number" name = "price" placeholder = "Enter new price" >
                <p>Description</p>
                <textarea  type="text" name = "pDesc" placeholader = "Enter new description"></textarea>
                <p>Category : <%= p.getCateName() %></p>
                <label>New Category : </label>
                <select name="pCategory" required>
                    <c:forEach var="cate" items="${requestScope.cateList}">
                        <option value="${cate.getId()}">${cate.getCateName()}</option>
                    </c:forEach>
                </select>
                <p>Old Status <%= p.getStatus() %></p>
                <label>New Status</label>
                <select name="status">
                    <option value="1">Available</option>
                    <option value="0">Unavailable</option>
                </select>
                <input type="hidden" value="<%= p.getId() %>" name="pid">
                <input type="submit" value="updatePlant" name="action">
                <a href="mainController?action=managePlants">Back to manage plant Page </a>
            </form>
        </div>
        <p>${requestScope.WARNING}</p>
    </body>
</html>
