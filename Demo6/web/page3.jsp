<%-- 
    Document   : page3
    Created on : Jun 21, 2022, 5:02:07 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="page3.jsp">
            <input type="number" name="txt" >
            <input type="submit" name="pow" >
            <p> result: ${param.txt * param.txt} </p>
        </form>
    </body>
</html>
