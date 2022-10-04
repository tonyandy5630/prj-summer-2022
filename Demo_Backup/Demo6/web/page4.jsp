<%-- 
    Document   : page4
    Created on : Jun 21, 2022, 1:34:30 PM
    Author     : thanhtra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <input type="text" name="txtnum" value="${param.txtnum}">
            <input type="submit" value="binhphuong">
            <h2>${ param.txtnum * param.txtnum }</h2>
        </form>
    </body>
</html>
