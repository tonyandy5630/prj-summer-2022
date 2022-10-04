<%-- 
    Document   : addPlant
    Created on : Jul 20, 2022, 9:40:35 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="add-container">
            <form action="mainController" method="post" class="form__addPlant">
                <input class="form__pName" type="text" name = "pName" placeholder = "Enter plant's name" required>
                <input class="form__pPrice" type="number" name = "price" placeholder = "Enter price" required>
                <textarea  type="text" name = "pDesc" placeholader = "Enter description"></textarea>
                <label>Category</label>
                <select name="pCategory" required>
                    <c:forEach var="cate" items="${requestScope.cateList}">
                        <option value="${cate.getId()}">${cate.getCateName()}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="addPlant" name="action">
                <p>${requestScope.WARNING}</p>
                <a href="mainController?action=managePlants">Back to manage plant Page </a>
            </form>
        </div>
    </body>
</html>
